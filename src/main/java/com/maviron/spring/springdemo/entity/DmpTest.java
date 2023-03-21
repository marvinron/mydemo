package com.maviron.spring.springdemo.entity;

import java.io.Serializable;

/**
 * 媒体应用包名(DmpTest)实体类
 *
 * @author makejava
 * @since 2023-03-21 10:13:44
 */
public class DmpTest implements Serializable {
    private static final long serialVersionUID = -59352177375974127L;
    /**
     * app名称
     */
    private String appName;
    /**
     * 包名
     */
    private String packageName;

    public DmpTest(String appName, String packageName) {
        this.appName = appName;
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
