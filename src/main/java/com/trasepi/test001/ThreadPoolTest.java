package com.trasepi.test001;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对 Java 线程池的探究 实践
 */
public class ThreadPoolTest {

    // @Test
    public void test() {

        // 获取逻辑处理器个数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 创建线程
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        // 关闭线程池
        pool.shutdown();
    }
}
