package com.maviron.spring.springdemo.controller;

import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.maviron.spring.springdemo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BeanSearchController.java
 * @Description TODO
 * @createTime 2022年03月14日 16:25:00
 */
@RestController
@RequestMapping("/user")
public class BeanSearchController {
    @Autowired
    private MapSearcher mapSearcher;
    @GetMapping("/index")
    public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
        // 这里咱们只写一行代码
        return mapSearcher.search(User.class, MapUtils.flat(request.getParameterMap()));
    }
}
