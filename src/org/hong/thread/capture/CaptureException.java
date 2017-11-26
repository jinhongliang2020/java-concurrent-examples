package org.hong.thread.capture;

/**
 * @ClassName: CaptureException
 * @Description: (使用Thread提供的api 方法，设置线程异常捕获处理的方法.)
 * @author hong
 * @date 2017/11/26
 * @version v1.1
 */
public class CaptureException {
    private final static int A = 10;
    private final static int B = 0;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2_000);
                int result = A / B;
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 设置线程异常捕获处理方法.
        t.setUncaughtExceptionHandler((thread,e)->{
            System.out.println(e);
            System.out.println(thread);
        });
        t.start();
    }

}
