/**
 * @author eamiear
 * @date 2018/7/30 16:30
 */

package com.ura.generator.utils;

import com.ura.common.utils.URAException;
import com.ura.generator.entity.ColumnEntity;
import com.ura.generator.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.app.Velocity;

import java.util.*;
import java.util.zip.ZipOutputStream;

public class GenUtils {

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/list.vue.vm");
        templates.add("template/list.html.vm");
        templates.add("template/list.js.vm");
        templates.add("template/menu.sql.vm");

        return templates;
    }

    public static void generateCode(Map<String, String> table, List<Map<String, String>> colums, ZipOutputStream zip) {
        Configuration config = getConfig();
        boolean hasBigDecimal = false;

        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));

        String className = tableName2JavaName(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        List<ColumnEntity> columnList = new ArrayList<>();
        for (Map<String, String> column : colums) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            String attrName = columnName2JavaName(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            String attrType = config.getString(columnEntity.getDataType(), "String");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrName.equals("BigDecimal")) {
                hasBigDecimal = true;
            }

            // 该属性列为主键，设置表格主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }
            columnList.add(columnEntity);
        }

        tableEntity.setColumns(columnList);

        // 没主键，这是第一个列属性为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        Properties properties = new Properties();
        properties.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(properties);

    }

    public static void velocityLaunch (Configuration config, TableEntity tableEntity, ZipOutputStream zipOutputStream) {
        Properties properties = new Properties();
        properties.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(properties);

        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("package", config.getString("package"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", "");
    }

    public static Configuration getConfig () {
        try{
            return new PropertiesConfiguration("generator.properties");
        }catch (ConfigurationException e) {
            throw new URAException("获取配置文件失败 ", e);
        }
    }

    public static String tableName2JavaName(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnName2JavaName(tableName);
    }

    public static String columnName2JavaName (String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }
}
