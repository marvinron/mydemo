package com.maviron.spring.springdemo.actor;



import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时任务
 */
public class TimerTask implements Comparable<TimerTask>{
	
	private int id;
	
	private static final AtomicInteger idGenerator = new AtomicInteger();
	
	private static final String LOG_FORMAT = "[time:{}, taskId:{}]";
	
	/**
	 * 执行时间（毫秒）
	 */
	private long execTime;
	
	/**
	 * 具体任务
	 */
	private Runnable task;
	
	public TimerTask(long execTime, Runnable task) {
		this.execTime = execTime;
		this.task = task;
		this.id = idGenerator.incrementAndGet();
	}
	
	/**
	 * 是否过期
	 */
	public boolean isExpired() {
		return System.currentTimeMillis() >= execTime;
	}

	@Override
	public int compareTo(TimerTask task) {
		return Long.compare(this.execTime, task.execTime);
	}
	
	public Runnable getTask() {
		return task;
	}
	
	/**
	 * 定时任务执行
	 */
	public void run() {
		task.run();
	}
	
	public long getExecTime() {
		return this.execTime;
	}
	
	public int getId() {
		return id;
	}
}
