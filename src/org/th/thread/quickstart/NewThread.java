package org.th.thread.quickstart;

/**
 * @ClassName: NewThread
 * @Description: (Thread quickstart)
 * @author hong
 * @date 2017/11/15
 * @version v1.1
 */
public class NewThread {

    public static void main(String[] args) {

        // 方式一：创建Thread类实例时，同时重写run方法.
        // 使用Thread 创建线程实例.
        Thread thread_1 =new Thread("thread_1"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"... Thread quickstart!");
            }
        };
        // 启动线程.
        thread_1.start();

        // new Thread(){
        //    @Override
        //    public void run() {
        //        System.out.println("anon thread.");
        //    }
        // }.start();


        // 方式二：使用外部定义的Thread 类
        SimpleThread simpleThread =new SimpleThread();
        simpleThread.start();


        // Runnable 不是线程，只是个接口；
        // 引入Runnable 实现类，主要是为了将 线程的控制 与业务逻辑分离开来。
        // java创建线程 只能使用Thread
        // 其实这里使用runnable 接口作为参数，有点类型模板方法的形式，
        // 使得子类可以不改变一个算法的结构即可重定义该算法的
        SimpleRunnable simpleRunnable =new SimpleRunnable();
        Thread thread_2 =new Thread(simpleRunnable);
        thread_2.start();
    }

    private static class  SimpleThread extends  Thread{
        @Override
        public void run() {
            System.out.println("simpleThread ...run!");
        }
    }

    private static class SimpleRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("simpleRunnable ...run!");
        }
    }
}
