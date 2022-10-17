package com.maviron.spring.springdemo.redisdistributedlock;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedisLockTypeEnum.java
 * @Description 自定义key的前缀
 * @createTime 2022年10月10日 10:04:00
 */
public enum  RedisLockTypeEnum {
    ONE("Business1", "Test1"),
    TWO("Business2", "Test2");

    private String code;
    private String desc;

    RedisLockTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getUniqueKey(String key) {
        return String.format("%s:%s", this.getCode(), key);
    }
}
