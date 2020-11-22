package com.erp.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;

import java.util.List;

/**
 * @author zwc
 * 转换给前端字段说明
 */
@Getter
public class PageConvert<T> {

    /**
     * 总数
     */
    private long totalCount;
    /**
     * 总页数
     */
    private long totalPage;
    /**
     * 页码
     */
    private long pageNum;
    /**
     * 每页数量
     */
    private long pageSize;
    /**
     * 数据
     */
    private List<T> list;

    public PageConvert(IPage<T> page) {
        this.totalCount = page.getTotal();
        this.pageNum = page.getCurrent();
        this.pageSize = page.getSize();
        this.totalPage = page.getPages();
        this.list = page.getRecords();
    }

}
