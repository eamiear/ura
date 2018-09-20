/**
 * @author eamiear
 * @date 2018/9/20 10:47
 */

package com.ura.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONUtils {
    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
        }
    }
    public static String toJsonString(Object obj){
        if (obj == null){
            return"{}";
        }
        if (obj instanceof String){
            if (StringUtils.isEmpty(obj.toString())){
                return "{}";
            }
        }
        String json = "";
        try {
            if (gson != null) {
                json = gson.toJson(obj);
            }
        } catch(Exception e) {
            return "{}";
        }
        return json;
    }

    public static <T> T fromJsonString(String json, Class<T> classOfT) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(json, classOfT);
        }
        return t;
    }

    public static <T> List<T> toList(String json, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
        }
        return list;
    }

    public static <T> List<Map<String, T>> toListMaps(String json){
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(json, new TypeToken<List<Map<String, T>>>(){}.getType());
        }
        return list;
    }

    public static <T> Map<String, T> toMap(String json){
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(json, new TypeToken<Map<String, T>>(){}.getType());
        }
        return map;
    }

    public static String fromJsonString(String json, String key){
        ObjectMapper mapper = new ObjectMapper();
        String value;
        JsonNode root;
        try{
            root = mapper.readTree(json);
            JsonNode data = root.path(key);
            value = data.asText();
        } catch (IOException e){
            value = null;
        }
        return value;
    }
}
