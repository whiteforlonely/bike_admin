package com.bike.admin.kernel;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {
	private static Hashtable<String, ThreadPoolManager> tb = new Hashtable<String, ThreadPoolManager>();

	// 线程池大小
	private final static int CORE_POOL_SIZE = 10;

	// 线程池最大线程数
	private final static int MAX_POOL_SIZE = 20;

	// 如果一个线程处在空闲状态的时间超过了该属性值，就会因为超时而退出
	private final static int KEEP_ALIVE_TIME = 180;

	// 工作任务队列最大数
	private final static int WORK_QUEUE_SIZE = 10000;

	// 线程池的拒绝策略生效，被拒绝的任务添加到队列内
	public Queue<Runnable> msgQueue = new LinkedList<Runnable>();

	// 线程池每次执行一个任务后，
	final Runnable accessBufferThread = new Runnable() {
		public void run() {
			// 鏌ョ湅鏄惁鏈夊緟瀹氳姹傦紝濡傛灉鏈夛紝鍒欐坊鍔犲埌绾跨▼姹犱腑
			if (hasMoreAcquire()) {
				// SearchTask task = ( SearchTask ) msgQueue.poll();
				threadPool.execute(msgQueue.poll());
			}
		}
	};

	// handler 线程池对拒绝任务的处理策略。
	final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			msgQueue.offer(r);
		}
	};

	// ArrayBlockingQueue:有界队列，FIFO，需要指定队列大小，如果队列满了，会触发线程池的RejectedExecutionHandler逻辑
	final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
			CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(WORK_QUEUE_SIZE), this.handler);

	// 周期任务调度，是基于线程池设计的定时任务类：定时任务与线程池功能结合使用
	final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(1);

	/** ScheduledFuture taskHandler ： sdk中没有实现类，只有在ScheduledExecutorService中提交了任务，会返回一个实现了ScheduledFuture接口的对象。*/ 
	final ScheduledFuture<?> taskHandler = scheduler.scheduleAtFixedRate(
			accessBufferThread, 0, 1, TimeUnit.SECONDS);

	/**
	 * 懒汉模式，当用到线程池时才创建对象
	 * 
	 * @param key
	 * @return
	 */
	public static synchronized ThreadPoolManager getInstance(String key) {
		ThreadPoolManager obj = tb.get(key);
		if (obj == null) {
			obj = new ThreadPoolManager();
			tb.put(key, obj);
		}

		return obj;
	}

	private ThreadPoolManager() {
	}

	private boolean hasMoreAcquire() {
		return !msgQueue.isEmpty();
	}

	public int getQueueSize() {
		return threadPool.getQueue().size();
	}

	public void addTask(Runnable task) {
		threadPool.execute(task);
	}
	
	public static void schedule(){
		
	}
}
