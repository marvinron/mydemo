package com.maviron.spring.springdemo.entity;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年02月22日 17:06:00
 */
public class Test {
    // 集合不为空
    List<RecipeCalendar> list;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 数据聚合转换
    Map<String, Map<Integer, RecipeCalendarInfoVO>> recipeCalendarDateMap = list.stream()
            .collect(
                    // 根据日期聚合
                    Collectors.groupingBy(recipeCalendar -> simpleDateFormat.format(recipeCalendar.getRecipeDate()),
                            // 保持顺序,用LinkedHashMap::new
                            LinkedHashMap::new,
                            // 根据日期区间(早,中,晚)聚合第二层
                            Collectors.groupingBy(RecipeCalendar::getIntervalType,
                                    // 保持顺序,用LinkedHashMap::new
                                    LinkedHashMap::new,
                                    // 处理内层list 转换为 RecipeCalendarInfoVO
                                    Collectors.collectingAndThen(Collectors.toList(), recipeCalendars -> {
                                                RecipeCalendarInfoVO recipeCalendarInfoVO = new RecipeCalendarInfoVO();
                                                recipeCalendarInfoVO.setCalories(recipeCalendars.stream().mapToInt(recipeCalendar -> recipeCalendar.getCalories() == null ? 0 : recipeCalendar.getCalories()).sum());
                                                recipeCalendarInfoVO.setRecipeCalendarList(recipeCalendars);
                                                return recipeCalendarInfoVO;
                                            }
                                    ))));
}
