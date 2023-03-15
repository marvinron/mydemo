package com.maviron.spring.springdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class RecipeCalendarInfoVO {
    private Integer calories;

    private List<RecipeCalendar> recipeCalendarList;
}