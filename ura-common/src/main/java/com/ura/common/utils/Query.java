/**
 * @author eamiear
 * @date 2018/7/30 17:32
 */

package com.ura.common.utils;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class Query<T> extends LinkedHashMap<String, Object>{

    private Page<T> page;
    // 页码
    private int pageNo = 1;
    // 记录数/每页
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);

        Object _page = params.get("page");
        Object _limit = params.get("limit");
        if (_page != null) {
            this.pageNo = Integer.parseInt(_page.toString());
        }
        if (_limit != null) {
            this.limit = Integer.parseInt(_limit.toString());
        }

        this.put("offset", (pageNo - 1) * limit);
        this.put("page", pageNo);
        this.put("limit", limit);

        this.page = new Page<>(pageNo, limit);
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
