package com.maviron.spring.springdemo.test;

import cn.hutool.core.util.SerializeUtil;
import com.maviron.spring.springdemo.entity.User;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConfigUtil {
    private static Map<String, Map<String, Object>> yamlData = null;

    private ConfigUtil() {
    }

    static {
        loads();
    }

    public static synchronized void loads() {
        InputStream inputStream = ConfigUtil.class.getResourceAsStream("/application.yml");
        Yaml yaml = new Yaml();
        try {
            yamlData = yaml.load(inputStream);
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static Object getenv() {
        /**
         * spring:
         *   profiles:
         *     active:
         */
        Map<String, String> map = (Map) yamlData.get("spring").get("profiles");
        return map.get("active");
    }



}