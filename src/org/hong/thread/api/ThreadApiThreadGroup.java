package org.hong.thread.api;


import java.util.Arrays;

/**
 * @author hong
 * @version v1.1
 * @Description: (Thread 类相关api 使用.)
 * @date 2017/11/16
 */
public class ThreadApiThreadGroup {

    public static void main(String[] args) {

        //线程组相关api
        Thread thread_1 = new Thread() {
            @Override
            public void run() {
                try {
                    // 100_000 jdk1.7以后可以使用这种定义数字的方式
                    Thread.sleep(100_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread_1.start();

        // 我们这里需要等一下，否则打开jconsole 时，main线程一执行完.
        // try {
        //     Thread.sleep(10_000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        //获取对应线程的所在线程组 getThreadGroup()
        System.out.println(thread_1.getThreadGroup());

        // 获取对应线程组的活动线程数 activeCount()
        // 我们这里获取到线程组活动线程数是3,有那几个呢？
        // 我们使用jvm 工具，jconsole 可以查看到
        // 1.thread-0(自定义线程，没有起名称，所以以-0 开始计数)
        // 2.main 线程，很容易理解，main方法启动时，main线程作为运行线程
        // 3.Monitor 线程，程序监视器,后续研究它的作用
        System.out.println(thread_1.getThreadGroup().activeCount());

        // 线程组名称,当线程没有定义名称时，获取其运行线程的线程组名称（也叫父线程组名称）
        System.out.println(thread_1.getThreadGroup().getName());

        // 枚举线程组实例
        ThreadGroup threadGroup = thread_1.getThreadGroup();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);

    }
}
