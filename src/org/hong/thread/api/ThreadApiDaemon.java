package org.hong.thread.api;

/**
 * @ClassName: ThreadApiDaemon
 * @Description: (Thread 类之守护线程相关api.)
 * @author hong
 * @date 2017/11/16
 * @version v1.1
 */
public class ThreadApiDaemon {

    public static void main(String[] args) {

//        Thread thread =new Thread(){
//            @Override
//            public void run() {
//                int count =0;
//                while (true){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("hello Daemon "+count++);
//                }
//            }
//        };
//        // 将自定义线程设置为守护线程，会随着运行线程停止而停止.
//        thread.setDaemon(true);
//        thread.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("hello Thread Daemon");


        // 当父线程为守护线程，那么其子线程也会随着父线程的终止而被终止.
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("hello child thread.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("hello world.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(1000);
            System.out.println("当我执行完毕时，子线程终止.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
