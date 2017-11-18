package org.hong.thread.sync;

/**
 * Created by hong on 2017/11/18.
 */
public class BankVersion2 {
    public static void main(String[] args) {
        final SynchronizedFunctionRunnable synchronizedRunnable =new SynchronizedFunctionRunnable();

        Thread thread_1 =new Thread(synchronizedRunnable,"一号柜台");
        Thread thread_2 =new Thread(synchronizedRunnable,"二号柜台");
        Thread thread_3 =new Thread(synchronizedRunnable,"三号柜台");

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}
