package com.maviron.spring.springdemo.until;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author cube.li
 * @date 2021/3/28 15:13
 * @description
 */
@SuppressWarnings("unused")
public final class IAssert {

    private static final String BLANK_SPACE = " ";

    public static void notNull(Object obj, String errorMsg) {

    }

    public static <T extends Throwable> void notNull(Object obj, Supplier<T> supplier) throws T {
        if (Objects.isNull(obj)) {
            throw supplier.get();
        }
    }

    public static void notNullStr(String str, String errorMsg) {
        if (StringUtils.isBlank(str)) {

        }
    }

    public static <T extends Throwable> void notNullStr(String str, Supplier<T> supplier) throws T {
        if (StringUtils.isBlank(str)) {
            throw supplier.get();
        }
    }

    public static void notEmptyCollection(Collection<?> collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {

        }
    }

    public static void afterNow(@NonNull LocalDateTime dateTime, String msg) {
        if (dateTime.isBefore(LocalDateTime.now())) {

        }
    }

    public static <N extends Comparable<? super N>> void notLarge(N n1, N n2, String msg) {
        if (ObjectUtils.compare(n1, n2) > 0) {

        }
    }

    public static void state(boolean condition, String msg) {
        if (!condition) {

        }
    }

    public static <T extends Throwable> void state(boolean condition, Supplier<? extends T> supplier) throws T {
        if (condition) {
            throw supplier.get();
        }
    }

    public static void justThrow(String msg) {

    }

    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        double systemLoadAverage = osBean.getSystemLoadAverage();
        System.out.println(systemLoadAverage);
    }

}
