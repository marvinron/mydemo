package com.maviron.spring.springdemo.until;

import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.IdUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 流量变现根据字符串的hash值进行权重分配
 *
 * @param <T>
 */
public class FlowWeightedRandomSelector<T> {

    private final List<Entry<T>> entries = new ArrayList<>();
    private double totalWeight = 0;

    public void add(double weight, T item) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        totalWeight += weight;
        entries.add(new Entry<>(totalWeight, item));
    }

    public T select(String param) {
        double r = hashCodeMod(param);
        int low = 0, high = entries.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (entries.get(mid).weight < r) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return entries.get(low).item;
    }
    private static long hashCodeMod(String param) {
        long hashValue = HashUtil.mixHash(param);
        long mod = 100;
        long digit = Math.abs(hashValue) % mod;
        return digit;
    }


    private static class Entry<T> {
        final double weight;
        final T item;

        Entry(double weight, T item) {
            this.weight = weight;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        FlowWeightedRandomSelector<String> selector = new FlowWeightedRandomSelector<>();
        selector.add(60, "A");
        selector.add(40, "B");
        //selector.add(3.0, "C");

        for (int i = 0; i < 100; i++) {
            String param = IdUtil.simpleUUID();
            String item = selector.select(param);
            System.out.println(item);
        }

    }
}
