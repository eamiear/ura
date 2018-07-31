/**
 * @author eamiear
 * @date 2018/7/30 16:29
 */

package com.ura.generator.service;

import com.ura.generator.dao.SysGeneratorDao;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class SysGeneratorService {

    @Autowired
    private SysGeneratorDao sysGeneratorDao;

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

        for (String tableName : tableNames) {
            Map<String, String> table = getTableByTableName(tableName);
            List<Map<String, String>> columns = getColumnsByTableName(tableName);
        }
        return outputStream.toByteArray();
    }
}
