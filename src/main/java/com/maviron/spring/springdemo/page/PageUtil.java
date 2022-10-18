package com.maviron.spring.springdemo.page;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 分页工具类：用于逻辑分页（数据量较小时使用）
 * @author: erlang
 * @date: 2021年07月29日 13:39
 */
public class PageUtil<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    private int totalCount;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页数
     */
    private int current;
    /**
     * 列表数据
     */
    private List<T> records;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param current    当前页数
     */
    public PageUtil(List<T> list, Integer totalCount, Integer pageSize, Integer current) {
        if (null == list || list.size() == 0) {
            this.records = new ArrayList<>();
        } else {
            //计算总页数
            Integer pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
            // 开始索引位置
            int beginIndex = 0;
            // 结束索引位置
            int endIndex = 0;
            //计算索引位置
            if (!current.equals(pageCount)) {
                beginIndex = (current - 1) * pageSize;
                endIndex = beginIndex + pageSize;
            } else {
                beginIndex = (current - 1) * pageSize;
                endIndex = totalCount;
            }
            this.records = list.subList(beginIndex, endIndex);
            this.totalCount = totalCount;
            this.pageSize = pageSize;
            this.current = current;
            this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
        }
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "PageUtilJb{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", current=" + current +
                ", records=" + records +
                '}';
    }

    public static void main(String[] args) {
        BigDecimal add = BigDecimal.valueOf(3150).add(BigDecimal.valueOf(2400))
                .add(BigDecimal.valueOf(150)).add(BigDecimal.valueOf(305)).add(BigDecimal.valueOf(1800));
        System.out.println(add.intValue());
    }
}
