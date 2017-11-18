package org.hong.thread.sync;

/**
 * @ClassName: SynchronizedRunnable
 * @Description: (使用同步代码块保证线程安全.)
 * @author hong
 * @date 2017/11/18
 * @version v1.1
 */
public class SynchronizedRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    /**
     * 锁对象
     */
    private final Object LOCK =new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                if (index <= MAX) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "的号码是：" + index++);
                }
            }
        }
    }
}
