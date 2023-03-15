package com.maviron.spring.springdemo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * DMP标签（新）(DmpTagNew)实体类
 *
 * @author makejava
 * @since 2023-03-07 14:42:51
 */
public class DmpTagNew implements Serializable {
    private static final long serialVersionUID = -58029614371739042L;

    private Integer id;

    private String name;
    /**
     * 分类父ID
     */
    private Integer parent;
    /**
     * 子节点信息
     */
    public List<DmpTagNew> childList;

    public List<DmpTagNew> getChildList() {
        return childList;
    }

    public void setChildList(List<DmpTagNew> childList) {
        this.childList = childList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

}
