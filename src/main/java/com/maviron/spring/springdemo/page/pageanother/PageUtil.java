package com.maviron.spring.springdemo.page.pageanother;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author Miracle Luna
 * @date 2021/7/16
 */
public class PageUtil {

    /**
     * 按照传入的参数，进行分页
     * @param pageNum  页数
     * @param pageSize 每页条数
     * @param sourceList 源列表
     * @param isPage 是否分页
     * @param <T> 泛型对象
     * @return 返回结果集
     */
    public static <T> ResultList<T> page(Integer pageNum, Integer pageSize, List<T> sourceList, Boolean isPage){

        ResultList<T> resultList = new ResultList<>();
        // 初始化总量为0，防止当列表为空的时候，total返回null
        resultList.setTotal(0);
        List<T> pageList = sourceList;

        // 当列表不为空的时候，才进行数据逻辑处理
        if (sourceList != null && !sourceList.isEmpty()) {
            int sourceSize = sourceList.size();
            if (isPage) {
                pageNum = (pageNum == null || pageNum <= 0) ? 1 : pageNum;
                pageSize = (pageSize == null || pageSize <= 0) ? 10 : pageSize;

                // 步骤分解，便于理解
//                int startPosition = Math.min((pageNum - 1) * pageSize, sourceSize);
//                int endPosition = Math.min(pageNum * pageSize, sourceSize);
//                pageList = sourceList.subList(startPosition, endPosition);
                // 分页的起始和截止位置，和源列表的size大小进行对比，分别取最小值
                pageList = sourceList.subList(Math.min((pageNum - 1) * pageSize, sourceSize), Math.min(pageNum * pageSize, sourceSize));
            }
            resultList.setList(pageList);
            resultList.setTotal(sourceSize);
        }

        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
//        List<Integer> intList = Lists.newArrayList();
//        ResultList<Integer> resultList = page(1, 3, intList, false);
//        ResultList<Integer> resultList = page(2, 3, intList, true);
//        ResultList<Integer> resultList = page(3, 3, intList, true);
//        ResultList<Integer> resultList = page(null, null, intList, true);
//        ResultList<Integer> resultList = page(2, 10, intList, true);
//        ResultList<Integer> resultList = page(2, 15, intList, true);
//        ResultList<Integer> resultList = page(1, 15, intList, true);
        ResultList<Integer> resultList = page(1, 10, intList, true);

        System.out.println("resultList: " + resultList);
    }
}