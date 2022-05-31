package com.maviron.spring.springdemo.until;

import com.cube.share.base.templates.CustomException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

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
        if (Objects.isNull(obj)) {
            throw new CustomException(errorMsg);
        }
    }

    public static <T extends Throwable> void notNull(Object obj, Supplier<T> supplier) throws T {
        if (Objects.isNull(obj)) {
            throw supplier.get();
        }
    }

    public static void notNullStr(String str, String errorMsg) {
        if (StringUtils.isBlank(str)) {
            throw new CustomException(errorMsg);
        }
    }

    public static <T extends Throwable> void notNullStr(String str, Supplier<T> supplier) throws T {
        if (StringUtils.isBlank(str)) {
            throw supplier.get();
        }
    }

    public static void notEmptyCollection(Collection<?> collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomException(msg);
        }
    }

    public static void afterNow(@NonNull LocalDateTime dateTime, String msg) {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new CustomException(msg);
        }
    }

    public static <N extends Comparable<? super N>> void notLarge(N n1, N n2, String msg) {
        if (ObjectUtils.compare(n1, n2) > 0) {
            throw new CustomException(msg);
        }
    }

    public static void state(boolean condition, String msg) {
        if (!condition) {
            throw new CustomException(msg);
        }
    }

    public static <T extends Throwable> void state(boolean condition, Supplier<? extends T> supplier) throws T {
        if (condition) {
            throw supplier.get();
        }
    }

    public static void justThrow(String msg) {
        throw new CustomException(msg);
    }

}
