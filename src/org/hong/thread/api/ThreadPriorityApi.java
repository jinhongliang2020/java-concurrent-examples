package org.hong.thread.api;



/**
 * @Description: (Thread 类api之线程优先级.)
 * @author hong
 * @date 2017/11/17
 * @version v1.1
 */
public class ThreadPriorityApi {

    public static void main(String[] args) {
        Thread thread_1 =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "-Index" + i);
                }
            }
        };
        thread_1.setPriority(Thread.NORM_PRIORITY);


        Thread thread_2 =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "-Index" + i);
                }
            }
        };
        thread_2.setPriority(Thread.MIN_PRIORITY);

        Thread thread_3 =new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "-Index" + i);
                }
            }
        };
        thread_3.setPriority(Thread.MAX_PRIORITY);

        // 注：设置为优先级高的不一定优先执行
        thread_1.start();
        thread_2.start();
        thread_3.start();

    }

}
