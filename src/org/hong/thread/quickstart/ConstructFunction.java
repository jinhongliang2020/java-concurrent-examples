package org.hong.thread.quickstart;

/**
 * @Description: (Thread 类构造函数详解)
 * @author hong
 * @date 2017/11/16
 * @version v1.1
 * @APIDOC  http://tool.oschina.net/apidocs/apidoc?api=jdk-zh
 */
public class ConstructFunction {

    public static void main(String[] args) {

        // Thread()
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run!");
            }
        }.start();

        // Thread(String name)  参数：1.线程名称
        new Thread("new-thread"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run!");
            }
        }.start();

        // Thread(Runnable target)  参数：1.Runnable 接口的实例.
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("target runnable run!");
            }
        }).start();

        // Thread(Runnable target, String name) 参数：1.Runnable 的接口实例 2.线程名称
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" run!");
            }
        },"new-thread-2").start();


        // Thread(ThreadGroup group, Runnable target)  参数：1.ThreadGroup 分组对象 2.Runnable 接口实例
        new Thread(new ThreadGroup("t"), new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组:"+Thread.currentThread().getThreadGroup().getName()+","+Thread.currentThread().getName()+" run!");
            }
        }).start();

        // Thread(ThreadGroup group, String name)  参数：1.ThreadGroup 分组对象 2.线程名称
        new Thread(new ThreadGroup("t2"),"new-thread-3"){
            @Override
            public void run() {
                System.out.println("线程组:"+Thread.currentThread().getThreadGroup().getName()+","+Thread.currentThread().getName()+" run!");
            }
        }.start();

        // Thread(ThreadGroup group, Runnable target, String name) 参数：1.ThreadGroup 分组对象 2.Runnable 接口实例 3.线程名称
        new Thread(new ThreadGroup("t3"), new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组:"+Thread.currentThread().getThreadGroup().getName()+","+Thread.currentThread().getName()+" run!");
            }
        },"new-thread-4").start();

        // Thread(ThreadGroup group, Runnable target, String name, long stackSize)
        // 参数：1.ThreadGroup 分组对象 2.Runnable 接口实例 3.线程名称 4.指定线程堆栈大小 ( stackSize 参数（如果有）的作用具有高度的平台依赖性)
        new Thread(new ThreadGroup("t4"), new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组:"+Thread.currentThread().getThreadGroup().getName()+","+Thread.currentThread().getName()+" run!");
            }
        },"new-thread-5",1024*10L).start();
    }
}
