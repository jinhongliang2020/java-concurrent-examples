package org.hong.thread.api;

import java.util.stream.IntStream;

/**
 * @Description: (Thread 类之join.)
 * @author hong
 * @date 2017/11/17
 * @version v1.1
 */
public class ThreadJoinApi {

    public static void main(String[] args) {
        // 一直等待
        testJoinAll();

        // 等待特定时间
        testJoinFor100();
    }

    private static void testJoinFor100() {
        Thread thread_1 =new Thread(){
            @Override
            public void run() {
                IntStream.range(1, 100)
                        .forEach(i -> {
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "->" + i);});
            }
        };

        thread_1.start();

        // main 线程等待thread_1 线程执行100ms 再执行.
        try {
            thread_1.join(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("等待所有join线程对应时间后，再执行main 线程.");
    }

    /**
     * 等待自定义线程执行完，再往下执行main线程.
     */
    private static void testJoinAll() {
        Thread thread_1 =new Thread(){
            @Override
            public void run() {
                IntStream.range(1, 1000)
                        .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
            }
        };

        Thread thread_2 =new Thread(){
            @Override
            public void run() {
                IntStream.range(1, 1000)
                        .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
            }
        };

        thread_1.start();
        thread_2.start();

        try {
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("等待所有join线程执行完，再执行main 线程.");
    }

}
