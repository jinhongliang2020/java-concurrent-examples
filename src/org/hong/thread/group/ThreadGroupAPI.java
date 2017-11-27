package org.hong.thread.group;

import java.util.Arrays;

/**
 * @ClassName: ThreadGroupAPI
 * @Description: (ThreadGroup API)
 * @author hong
 * @date 2017/11/27
 * @version v1.1
 */
public class ThreadGroupAPI {


    public static void main(String[] args) {

        ThreadGroup tg1 =new ThreadGroup("tg1");
        Thread thread =new Thread(tg1,"thread"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread.start();

        ThreadGroup tg2 =new ThreadGroup(tg1,"tg2");
        Thread thread2 =new Thread(tg2,"thread2"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        thread2.start();

        // 获取对应线程threadGroup name.
        System.out.println(thread.getThreadGroup().getName());
        // 对应线程组活跃线程数.
        System.out.println(thread.getThreadGroup().activeCount());
        // 活跃线程组数.
        System.out.println(thread.getThreadGroup().activeGroupCount());

        // 打印出对应线程组的线程信息.
        Thread[] threads =new Thread[thread.getThreadGroup().activeCount()];
        tg1.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);


        // 中断线程组.
        tg1.interrupt();

    }
}
