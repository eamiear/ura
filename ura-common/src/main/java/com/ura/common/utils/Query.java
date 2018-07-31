/**
 * @author eamiear
 * @date 2018/7/30 17:32
 */

package com.ura.common.utils;

import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query extends LinkedHashMap<String, Object>{

    // 页码
    private int page;
    // 记录数/每页
    private int limit;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        Object _page = params.get("page");
        Object _limit = params.get("limit");
        if (_page != null && _limit != null) {
            this.page = Integer.parseInt(_page.toString());
            this.limit = Integer.parseInt(_limit.toString());
            this.put("offset", (page - 1) * limit);
            this.put("page", page);
            this.put("limit", limit);
        }
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
