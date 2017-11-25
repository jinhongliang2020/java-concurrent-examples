package org.hong.thread.customlock;

import java.util.Optional;

/**
 * @author hong
 * @version v1.1
 * @ClassName: SynchronizedProblem
 * @Description: (测试synchronized 持有锁无法被中断.)
 * @date 2017/11/25
 */
public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            SynchronizedProblem.run();
        });

        thread.start();
        Thread.sleep(2000);

        // 中断线程,可以查看到线程状态为中断，但实际情况是synchronized 标记的方法或代码块是无法中断的
        thread.interrupt();

        Optional.of(Thread.currentThread().getName() + " 中断状态:" +
                thread.isInterrupted()).ifPresent(System.out::println);
    }


    public static void run() {
        synchronized(SynchronizedProblem.class) {
            while (true) {

            }
        }
    }
}
