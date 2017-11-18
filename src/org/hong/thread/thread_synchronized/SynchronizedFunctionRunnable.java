package org.hong.thread.thread_synchronized;

/**
 * Created by hong on 2017/11/18.
 */
public class SynchronizedFunctionRunnable implements Runnable {


    private int index = 1;

    private final static int MAX = 500;

    @Override
    public void run() {
        while (true) {
            if (ticket())
                break;
        }
    }

    private synchronized boolean ticket() {
        if (index > MAX)
            return true;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "的号码是：" + index++);
        return false;
    }
}
