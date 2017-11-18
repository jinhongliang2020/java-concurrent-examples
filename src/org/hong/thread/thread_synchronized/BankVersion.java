package org.hong.thread.thread_synchronized;

/**
 * @ClassName: Bank
 * @Description: (模拟银行叫号，当多线程使用共享数据时，使用synchronized 解决线程安全问题 )
 * @author hong
 * @date 2017/11/18
 * @version v1.1
 */
public class BankVersion {

    public static void main(String[] args) {
        final SynchronizedRunnable synchronizedRunnable =new SynchronizedRunnable();

        Thread thread_1 =new Thread(synchronizedRunnable,"一号柜台");
        Thread thread_2 =new Thread(synchronizedRunnable,"二号柜台");
        Thread thread_3 =new Thread(synchronizedRunnable,"三号柜台");

        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}
