package com.maviron.spring.springdemo.arithmetic;

import com.maviron.spring.springdemo.entity.User;
import com.maviron.spring.springdemo.entity.UserVo;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName BinarySearch.java
 * @Description
 * @createTime 2024年01月08日 10:00:00
 */
public class BinarySearch { //二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    static void selectionSort(int[] arr) {  // 选择排序
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    // 交换
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }
            System.out.println("第"+(i+1)+"趟："+Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        User user = null;
        //String s = Optional.ofNullable(user).map(User::getUserVo).map(UserVo::getEmail).orElse("没有邮箱信息啊");
        //System.out.println(s);
        User user1 = Optional.ofNullable(user).orElseGet(User::new);
        user1.setName("adsadasdasdas");
        System.out.println(user1.toString());
    }
}
