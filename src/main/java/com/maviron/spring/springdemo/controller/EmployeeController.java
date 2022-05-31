package com.maviron.spring.springdemo.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.maviron.spring.springdemo.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName EmployeeController.java
 * @Description TODO
 * @createTime 2022年03月15日 09:44:00
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private BeanSearcher beanSearcher;

    @Autowired
    private MapSearcher mapSearcher;

    /**
     * 员工列表检索接口
     */
    @GetMapping("/index")
    public Object index(@RequestParam Map<String, Object> params) {
        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
        return beanSearcher.search(Employee.class, params, new String[] { "age" });
    }

    @GetMapping("/builder")
    public Object index() {
        // 参数组
        Map<String, Object> params = MapUtils.builder()
                .group("a")
                .field(Employee::getName, "Jack")
                .field(Employee::getGender, "Male")
                .group("b")
                .field(Employee::getName, "Tom")
                .group("c")
                .field(Employee::getAge, 20)
                .groupExpr("a|b&c")
                .build();
        return beanSearcher.searchCount(Employee.class, params);
    }

//    /**
//     * 测试带冗余后缀的实体类
//     */
//    @GetMapping("/index-vo")
//    public Object indexVo(@RequestParam Map<String, Object> params) {
//        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
//        return beanSearcher.searchList(EmployeeVO.class,
//                MapUtils.builder()
//                        .field(EmployeeVO::getAge).op(MyOp.class)
//                        .build()
//        );
////		return beanSearcher.searchList(EmployeeVO.class, params);
//    }

    @GetMapping("/count")
    public Object count(HttpServletRequest request) {
        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
        return beanSearcher.searchCount(Employee.class,				// 指定实体类
                MapUtils.flat(request.getParameterMap()));					// 统计字段：年龄
    }

    @GetMapping("/sum")
    public Object sum(HttpServletRequest request) {
        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
        return beanSearcher.searchSum(Employee.class,				// 指定实体类
                MapUtils.flat(request.getParameterMap()), "age");					// 统计字段：年龄
    }

    @GetMapping("/sums")
    public Object sums(HttpServletRequest request) {
        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
        return beanSearcher.searchSum(Employee.class,				// 指定实体类
                MapUtils.flat(request.getParameterMap()), new String[] {"id", "age"});					// 统计字段：年龄
    }

    /**
     * 员工列表检索接口
     */
    @GetMapping("/map")
    public Object map(HttpServletRequest request) {
        // 组合检索、排序、分页 和 统计 都在这一句代码中实现了
        return mapSearcher.search(Employee.class,				// 指定实体类
                MapUtils.flat(request.getParameterMap()), 	// 直接收集前端传来的检索参数，此种方式代码最为简洁
                new String[] { "age" });					// 统计字段：年龄
    }

}
