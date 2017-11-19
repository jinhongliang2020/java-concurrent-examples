package org.hong.thread.sync;

/**
 * @ClassName: SynchronizedStaticTest
 * @Description: (用来证明static 同步方法使用的是同步方法类class锁.)
 * @author hong
 * @date 2017/11/18
 * @version v1.1
 */
public class SynchronizedStaticTest {

    // 验证得到 ，当static 代码块加载时，其他线程没有运行
    // 也就是说，其他线程使用的是相同的锁.
    public static void main(String[] args) {
        new Thread("t1"){
            @Override
            public void run() {
               SynchronizedStatic.m1();
            }
        }.start();

        new Thread("t2"){
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }
        }.start();

        new Thread("t3"){
            @Override
            public void run() {
                SynchronizedStatic.m3();
            }
        }.start();

    }
}
