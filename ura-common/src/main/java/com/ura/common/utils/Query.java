/**
 * @author eamiear
 * @date 2018/7/30 17:32
 */

package com.ura.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String, Object>{

    // 页码
    private int page;
    // 记录数/每页
    private int limit;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("offset", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
