/**
 * @author eamiear
 * @date 2018/7/30 22:53
 */

package com.ura.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

public class PageUtils implements Serializable {

    private int count;
    private int total;
    private int pageNo;
    private int pageSize;
    private List<?> list;

    public PageUtils (List<?> list, int count, int pageSize, int pageNo) {
        this.list = list;
        this.count = count;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        if (pageSize == 0) {
            pageSize = 1;
        }
        this.total = (int)Math.ceil((double)count / pageSize);
    }

    public PageUtils (Page<?> page){
        this.list = page.getRecords();
        this.count = page.getTotal();
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        this.total = page.getPages();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
