package com.maviron.spring.springdemo.demo.handletree;

import org.json.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName TestTreeMenu.java
 * @Description lambda表达式校验树
 * @createTime 2021年11月25日 09:47:00
 */
public class TestTreeMenu {
    @Test
    public void test() {
        //模拟数据
        List<Menu> menus = Arrays.asList(
                new Menu(1, "根节点", 0),
                new Menu(2, "子节点1", 1),
                new Menu(3, "子节点1.1", 2),
                new Menu(4, "子节点1.2", 2),
                new Menu(5, "根节点1.3", 2),
                new Menu(6, "根节点2", 1),
                new Menu(7, "根节点2.1", 6),
                new Menu(8, "根节点2.2", 6),
                new Menu(9, "根节点2.2.1", 7),
                new Menu(10, "根节点2.2.2", 7),
                new Menu(11, "根节点3", 1),
                new Menu(12, "根节点3.1", 11)
        );
        List<Menu> collect = menus.stream().filter(menu -> 0 == menu.getParentId()).map(menu -> {
            menu.setChildList(getChidList(menu, menus));
            return menu;
        }).collect(Collectors.toList());
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(collect));
    }

    private List<Menu> getChidList(Menu root, List<Menu> menus) {
        List<Menu> collect = menus.stream().filter(menu -> Objects.equals(menu.getParentId(), root.getId())).map(menu -> {
            menu.setChildList(getChidList(menu, menus));
            return menu;
        }).collect(Collectors.toList());
        return collect;
    }


}
