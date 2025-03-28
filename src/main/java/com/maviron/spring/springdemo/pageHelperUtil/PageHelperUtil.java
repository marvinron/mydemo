package com.maviron.spring.springdemo.pageHelperUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * 生产上使用过的
 */
public class PageHelperUtil {

    public static <T> PageInfo<T> listToPage(List<T> arrayList, Integer pageNum, Integer pageSize) {
        //实现list分页
        PageHelper.startPage(pageNum, pageSize);
        int pageStart = pageNum == 1 ? 0 : (pageNum - 1) * pageSize;
        int pageEnd = Math.min(arrayList.size(), pageSize * pageNum);
        List<T> pageResult = new LinkedList<>();
        if (arrayList.size() > pageStart) {
            pageResult = arrayList.subList(pageStart, pageEnd);
        }
        PageInfo<T> pageInfo = new PageInfo<>(pageResult);
        //获取PageInfo其他参数
        pageInfo.setTotal(arrayList.size());
        int endRow = pageInfo.getEndRow() == 0 ? 0 : (pageNum - 1) * pageSize + pageInfo.getEndRow() + 1;
        pageInfo.setEndRow(endRow);
        boolean hasNextPage = arrayList.size() > pageSize * pageNum;
        pageInfo.setHasNextPage(hasNextPage);
        boolean hasPreviousPage = pageNum != 1;
        pageInfo.setHasPreviousPage(hasPreviousPage);
        pageInfo.setIsFirstPage(!hasPreviousPage);
        boolean isLastPage = arrayList.size() > pageSize * (pageNum - 1) && arrayList.size() <= pageSize * pageNum;
        pageInfo.setIsLastPage(isLastPage);
        int pages = arrayList.size() % pageSize == 0 ? arrayList.size() / pageSize : (arrayList.size() / pageSize) + 1;
        pageInfo.setNavigateLastPage(pages);
        int[] navigatePageNums = new int[pages];
        for (int i = 1; i < pages; i++) {
            navigatePageNums[i - 1] = i;
        }
        pageInfo.setNavigatepageNums(navigatePageNums);
        int nextPage = pageNum < pages ? pageNum + 1 : 0;
        pageInfo.setNextPage(nextPage);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages(pages);
        pageInfo.setPrePage(pageNum - 1);
        pageInfo.setSize(pageInfo.getList().size());
        int starRow = arrayList.size() < pageSize * pageNum ? 1 + pageSize * (pageNum - 1) : 0;
        pageInfo.setStartRow(starRow);
        PageHelper.clearPage();
        return pageInfo;
    }

}
