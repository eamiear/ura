/**
 * @author eamiear
 * @date 2018/7/30 16:16
 */

package com.ura.generator.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysGeneratorDao {

    List<Map<String, String>> getTableList (Map<String, Object> map);

    int getTableTotal(Map<String, Object> map);

    Map<String, String> getTableByTableName(String tableName);

    List<Map<String, String>> getColumnsByTableName(String tableName);
}
