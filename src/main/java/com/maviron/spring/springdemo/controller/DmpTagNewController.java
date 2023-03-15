package com.maviron.spring.springdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.maviron.spring.springdemo.entity.DmpTagNew;
import com.maviron.spring.springdemo.service.DmpTagNewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DMP标签（新）(DmpTagNew)表控制层
 *
 * @author makejava
 * @since 2023-03-07 14:42:54
 */
@RestController
@RequestMapping("dmpTagNew")
public class DmpTagNewController {
    /**
     * 服务对象
     */
    @Resource
    private DmpTagNewService dmpTagNewService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DmpTagNew selectOne(Integer id) {
        return this.dmpTagNewService.queryById(id);
    }

    @RequestMapping("queryAll")
    public String queryAll(){
        List<DmpTagNew> dmpTagNews = dmpTagNewService.queyyAll();
        List<DmpTagNew> collect = dmpTagNews.stream().filter(m -> m.getParent() == 0).map(
                (m) -> {
                    m.setChildList(getChildrens(m, dmpTagNews));
                    return m;
                }
        ).collect(Collectors.toList());
        System.out.println("-------转json输出结果-------");
        return JSONObject.toJSONString(collect);
    }
    /**
     * 递归查询子节点
     * @param root  根节点
     * @param all   所有节点
     * @return 根节点信息
     */
    private List<DmpTagNew> getChildrens(DmpTagNew root, List<DmpTagNew> all) {
        List<DmpTagNew> children = all.stream().filter(m -> {
            return Objects.equals(m.getParent(), root.getId());
        }).map(
                (m) -> {
                    m.setChildList(getChildrens(m, all));
                    return m;
                }
        ).collect(Collectors.toList());
        return children;
    }

}
