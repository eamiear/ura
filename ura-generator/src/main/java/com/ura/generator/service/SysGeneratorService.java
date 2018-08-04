/**
 * @author eamiear
 * @date 2018/7/30 16:29
 */

package com.ura.generator.service;

import com.ura.common.utils.PageUtils;
import com.ura.generator.dao.SysGeneratorDao;
import com.ura.generator.entity.PropsEntity;
import com.ura.generator.redis.GeneratorRedis;
import com.ura.generator.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class SysGeneratorService {

    @Autowired
    private SysGeneratorDao sysGeneratorDao;

    @Autowired
    private GeneratorPropsService generatorPropsService;

    @Autowired
    private GeneratorRedis generatorRedis;

    public List<Map<String, String>> getTableList(Map<String, Object> map){
        return sysGeneratorDao.getTableList(map);
    }

    public int getTableTotal(Map<String, Object> map) {
        return sysGeneratorDao.getTableTotal(map);
    }

    public Map<String, String> getTableByTableName(String tableName) {
        return sysGeneratorDao.getTableByTableName(tableName);
    }

    public List<Map<String, String>> getColumnsByTableName(String tableName) {
        return sysGeneratorDao.getColumnsByTableName(tableName);
    }

    public byte[] generateCode(String[] tableNames){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        PageUtils pageUtils = generatorPropsService.queryPropsList(new HashMap<>());
        if (pageUtils.getList().size() > 0) {
            List<PropsEntity> list = (List<PropsEntity>)pageUtils.getList();
            for (PropsEntity propsEntity : list) {
                generatorRedis.set(propsEntity);
            }
        }

        for (String tableName : tableNames) {
            Map<String, String> table = getTableByTableName(tableName);
            List<Map<String, String>> columns = getColumnsByTableName(tableName);
            GenUtils.generateCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
