package com.maviron.spring.springdemo.until;

import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.entity.UserVo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
/**
 * @title beanutl listcopy
 * @description
 * @author houlei
 * @see  org.springframework.beans.BeanUtils
 */
public class BeanCopyUtil extends BeanUtils {

    /**
     * 集合数据的拷贝
     * @param sources: 数据源类
     * @param target: 目标类
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     * @param sources: 数据源类
     * @param target: 目标类
     * @param callBack: 回调函数
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setName("dabai");
        user.setAge(11);
        list.add(user);
        User user1 = new User();
        user1.setId("1");
        user1.setName("dabai");
        user1.setAge(11);
        list.add(user1);
        List<UserVo> userVos = BeanCopyUtil.copyListProperties(list, UserVo::new);
        System.out.println(userVos);
        System.out.println("==============");
        System.out.println(list);


    }
}
