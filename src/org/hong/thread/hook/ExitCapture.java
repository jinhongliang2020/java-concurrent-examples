package org.hong.thread.hook;


/**
 * @author hong
 * @version v1.1
 * @ClassName: ExitCapture
 * @Description: (程序异常退出或者kill pid, 捕获并执行逻辑块.)
 * @date 2017/11/26
 */
public class ExitCapture {

    public static void main(String[] args) {

        // 在jvm中增加一个关闭的钩子，当jvm关闭的时候，会执行系统中已经设置的所有通过方法addShutdownHook添加的钩子，
        // 当系统执行完这些钩子后，jvm才会关闭。
        // 注：程序执行完成，或者发生异常都会执行这里钩子程序.
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("the application will be exit.");
            notityAddRelease();
        }));

//        int i = 0;
//        while (true) {
//            try {
//                Thread.sleep(1_000);
//                System.out.println("I am  working...");
//            } catch (InterruptedException e) {
//                //e.printStackTrace();
//                //ignore
//            }
//            i++;
//            if (i >= 20) throw new RuntimeException("error");
//        }

        System.out.println("hello world!");

    }

    private static void notityAddRelease() {
        System.out.println("will release resource(socket,file,connection...)");
    }
}
