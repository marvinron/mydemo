package com.maviron.spring.springdemo.until;

import com.cube.share.base.function.SerializableFunction;
import com.cube.share.base.templates.SerializedLambda;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author poker.li
 * @date 2021/8/8 15:07
 * <p>
 * Lambda解析工具类
 */
public final class LambdaUtils {

    private static final Map<String, WeakReference<SerializedLambda>> FUNC_CACHE = new ConcurrentHashMap<>();

    /**
     * 解析 lambda 表达式,并添加了缓存,该缓存可能会在任意不定的时间被清除
     *
     * @param func 需要解析的 lambda 对象
     * @param <T>  类型,被调用的 Function 对象的目标类型
     * @return 返回解析后的结果
     * @see SerializedLambda#resolve(SerializableFunction)
     */
    public static <T> SerializedLambda resolve(SerializableFunction<T, ?> func) {
        Class<?> clazz = func.getClass();
        String canonicalName = clazz.getCanonicalName();
        return Optional.ofNullable(FUNC_CACHE.get(canonicalName))
                .map(WeakReference::get)
                .orElseGet(() -> {
                    SerializedLambda lambda = SerializedLambda.resolve(func);
                    FUNC_CACHE.put(canonicalName, new WeakReference<>(lambda));
                    return lambda;
                });
    }
}
