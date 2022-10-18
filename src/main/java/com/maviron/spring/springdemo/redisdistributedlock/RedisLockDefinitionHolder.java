package com.maviron.spring.springdemo.redisdistributedlock;

/**
 * @author houlei
 * @version 1.0.0
 * @ClassName RedisLockDefinitionHolder.java
 * @Description 任务队列保存参数
 * @createTime 2022年10月18日 10:04:00
 */
public class RedisLockDefinitionHolder {
    /**
     * 业务唯一key
     */
    private String businessKey;
    /**
     * 加锁时间（秒）
     */
    private Long lockTime;
    /**
     * 上次更新时间（ms）
     */
    private Long lastModifyTime;
    /**
     * 当前线程
     */
    private Thread currentThread;
    /**
     * 重试次数
     */
    private int tryCount;
    /**
     * 当前尝试次数
     */
    private int currentCount;

    /**
     * 更新的时间周期（毫秒）,公式 = 加锁时间（转成毫秒） / 3
     */
    private Long modifyPeriod;

    public RedisLockDefinitionHolder(String businessKey, Long lockTime, Long lastModifyTime, Thread currentTread, int tryCount) {
        this.businessKey = businessKey;
        this.lockTime = lockTime;
        this.lastModifyTime = lastModifyTime;
        this.currentThread = currentTread;
        this.tryCount = tryCount;
        this.modifyPeriod = lockTime * 1000 / 3;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Long getLockTime() {
        return lockTime;
    }

    public void setLockTime(Long lockTime) {
        this.lockTime = lockTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Thread getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(Thread currentThread) {
        this.currentThread = currentThread;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public Long getModifyPeriod() {
        return modifyPeriod;
    }

    public void setModifyPeriod(Long modifyPeriod) {
        this.modifyPeriod = modifyPeriod;
    }
}
