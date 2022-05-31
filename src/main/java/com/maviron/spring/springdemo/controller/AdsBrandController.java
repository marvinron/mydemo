package com.maviron.spring.springdemo.controller;

import com.maviron.spring.springdemo.entity.AdsBrand;
import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.service.AdsBrandService;
import org.assertj.core.util.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (AdsBrand)表控制层
 *
 * @author makejava
 * @since 2022-04-07 10:37:51
 */
@RestController
@RequestMapping("adsBrand")
public class AdsBrandController {
    /**
     * 服务对象
     */
    @Resource
    private AdsBrandService adsBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AdsBrand selectOne(Integer id) {

        return this.adsBrandService.queryById(id);
    }

    public static void main(String[] args) {
        List<User> collect = new ArrayList<>();
        User user1 = new User();
        user1.setId("1");
        user1.setName("rwerwe");
        user1.setSequence(2);
        User user2 = new User();
        user2.setId("2");
        user2.setName("fdfgfgh");
        user2.setSequence(1);
        collect.add(user1);
        collect.add(user2);
        //collect.sort(Comparator.comparing(User::getId));
        collect.sort(Comparator.comparing(User::getSequence).reversed());
        collect.forEach(user -> {
            System.out.println(user);
        });
    }

    public static String test(){
        for (int i = 0; i < 10; i++) {
            if(i==5){
                return "stop";
            }
            return "hello";
        }
        return "end";
    }

}
