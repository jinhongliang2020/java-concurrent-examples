package org.hong.thread.api;


/**
 * @Description: (Thread 类其他简单api.)
 * @author hong
 * @date 2017/11/17
 * @version v1.1
 */
public class ThreadSimpleApi {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"run!");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"run!");
            }
        });
        thread.start();

        // 线程id
        System.out.println("线程thread-0 的线程id："+thread.getId());

        // 状态 state
        System.out.println("线程thread-0 的线程状态："+thread.getState());

        // 是否处于活动状态
        System.out.println("线程thread-0 是否处于活动状态："+thread.isAlive());

        // 是否是守护线程
        System.out.println("线程thread-0 是否是守护线程："+thread.isDaemon());

        // 是否已经中断
        System.out.println("线程thread-0 是否已经中断："+thread.isInterrupted());

    }
}
