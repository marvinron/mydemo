package com.maviron.spring.springdemo.until;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {
    /**
     * 根据权重获取下标
     * @param weight
     * @return
     */
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
