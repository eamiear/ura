/**
 * @author eamiear
 * @date 2018/7/30 22:53
 */

package com.ura.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

public class PageUtils implements Serializable {

    private int total;
    private int pages;
    private int pageNo;
    private int pageSize;
    private List<?> list;

    public PageUtils (List<?> list, int total, int pageSize, int pageNo) {
        this.list = list;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        if (pageSize == 0) {
            pageSize = 1;
        }
        this.pages = (int)Math.ceil((double)total / pageSize);
    }

    public PageUtils (Page<?> page){
        this.list = page.getRecords();
        this.total = page.getTotal();
        this.pageNo = page.getCurrent();
        this.pageSize = page.getSize();
        this.pages = page.getPages();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
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
