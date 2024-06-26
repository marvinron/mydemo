package com.maviron.spring.springdemo.until;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 权重的工具类
 *
 * @param <T>
 */
public class WeightedRandomSelector<T> {

    private final List<Entry<T>> entries = new ArrayList<>();
    private final Random random = new Random();
    private double totalWeight = 0;

    public void add(double weight, T item) {
        //if (weight <= 0) {
        //    throw new IllegalArgumentException("Weight must be positive");
        //}
        totalWeight += weight;
        entries.add(new Entry<>(totalWeight, item));
    }

    public T select() {
        double r = random.nextDouble() * totalWeight;
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

    private static class Entry<T> {
        final double weight;
        final T item;

        Entry(double weight, T item) {
            this.weight = weight;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        WeightedRandomSelector<String> selector = new WeightedRandomSelector<>();
        selector.add(0, "A");
        selector.add(50, "B");
        selector.add(50, "C");


        for (int i = 0; i < 100; i++) {
            String item = selector.select();
            System.out.println(item);
        }
        //for (int i = 0; i < 100; i++) {
        //    List<Integer> list = Arrays.asList(90, 10);
        //    System.out.println(list);
        //    int index = random(Arrays.asList(90,10));
        //    System.out.println(index == 0);
        //}
    }

    public static int random(List<Integer> weight) {
        List<Integer> weightTmp = new ArrayList<>(weight.size() + 1);
        weightTmp.add(0);
        Integer sum = 0;
        for (Integer d : weight) {
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        for (int i = weightTmp.size() - 1; i > 0; i--) {
            if (rand >= weightTmp.get(i)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
