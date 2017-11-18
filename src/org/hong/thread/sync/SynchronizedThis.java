package org.hong.thread.sync;

/**
 * @ClassName: SynchronizedThis
 * @Description: (这里用一句话描述这个类的作用)
 * @author hong
 * @date 2017/11/18
 * @version v1.1
 */
public class SynchronizedThis {

    public static void main(String[] args) {
        ThisLock thisLock =new ThisLock();

        // 启动两个线程执行对应的同步方法
        // 可以很明显看到，当一个线程执行时，另一个线程正在等待
        // 也就是说他们使用的是同一个锁，this锁.
        // 注：当然，你使用自定义显示锁，效果是一个样的，反正都是使用了同一个锁
        new Thread("thread-test"){
            @Override
            public void run() {
                thisLock.test();
            }
        }.start();

        new Thread("thread-test2"){
            @Override
            public void run() {
                thisLock.test2();
            }
        }.start();

    }
}

class ThisLock {

    public synchronized void test() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
