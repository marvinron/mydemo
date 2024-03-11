package com.maviron.spring.springdemo.cache.mycache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName MyLRUCache.java
 * @Description LRU cache 继承linkHashMap
 * @createTime 2024年03月08日 14:48:00
 */
public class MyLRUCache extends LinkedHashMap {
    /**
     * 自己定义容量
     */
    private int capacity;

    public MyLRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /**
     * 获取元素 调用父类的方法
     * 原理：
     * (1):首先将这个元素从队列中移除
     * (2):然后将这个元素添加到队列头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    /**
     * 得到元素，调用父类的方法
     * 原理：
     * （1）首先判断key所代表的元素是否在队列中
     * （2）如果在队列中，则覆盖元素的key即可
     * （3）覆盖之后 则从队列中移除 再添加到队列头部
     * （4）此时操作完成
     * （5）如果不在队列中，则判断容量是否足够
     * （6）如果容量足够，则添加到队列头部，此时操作完成
     * （7）如果容量不足够，则移除队列的最后一个元素
     * （8）并且将要添加的元素，添加到队列头部，此时操作完成
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 移除元素的方法：因为在linkedhashMap中是空方法，
     * 所以我们需要重写方法，定义自己的逻辑
     * 这里就是当容量不够时移除自己的元素
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }
}
