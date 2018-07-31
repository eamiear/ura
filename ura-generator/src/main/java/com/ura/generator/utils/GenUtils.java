/**
 * @author eamiear
 * @date 2018/7/30 16:30
 */

package com.ura.generator.utils;

import com.ura.common.utils.DateUtils;
import com.ura.common.utils.URAException;
import com.ura.generator.entity.ColumnEntity;
import com.ura.generator.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.zip.ZipEntry;
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

        renderAndZip(config, tableEntity, zip);
    }

    public static void renderAndZip (Configuration config, TableEntity tableEntity, ZipOutputStream zipOutputStream) {
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
        map.put("datetime", DateUtils.format(new Date()));
        VelocityContext context = new VelocityContext(map);

        List<String> templates = getTemplates();
        for (String template : templates) {
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);

            try {
                zipOutputStream.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"))));
                IOUtils.write(sw.toString(), zipOutputStream, "UTF-8");
                IOUtils.closeQuietly(sw);
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                throw new URAException("模板渲染失败, 表名： " + tableEntity.getTableName(), e);
            }
        }
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

    public static String getFileName(String template, String className, String packageName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        String resourcePath = "main" + File.separator + "resources" + File.separator;

        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator;
        }
        if (template.contains("Entity.java.vm")) {
            return packagePath + "entity" + File.separator + className + "Entity.java";
        }
        if (template.contains("Dao.java.vm")) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Dao.xml.vm")) {
            return resourcePath + "mapper" + File.separator + className + "Dao.xml";
        }

        if (template.contains("list.vue.vm")) {
            return resourcePath + "templates" + File.separator + className.toLowerCase() + ".vue";
        }

        if (template.contains("list.html.vm")) {
            return resourcePath + "templates" + File.separator + className.toLowerCase() + ".html";
        }

        if (template.contains("list.js.vm")) {
            return resourcePath + "static" + File.separator + "js" + File.separator + className.toLowerCase() + ".js";
        }

        if (template.contains("menu.sql.vm")) {
            return className.toLowerCase() + "_menu.sql";
        }
        return null;
    }
}
