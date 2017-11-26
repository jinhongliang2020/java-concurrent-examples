package org.hong.thread.capture;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName: ThreadTrace
 * @Description: (查看线程调用链.)
 * @author hong
 * @date 2017/11/26
 * @version v1.1
 */
public class ThreadTrace {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            show();
        });
        t.start();

        // 打印线程执行类调用链情况.
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(el -> !el.isNativeMethod()).
                forEach(el -> Optional.of(el.getClassName() + ":"
                        + el.getMethodName() + ":"
                        + el.getLineNumber()).ifPresent(System.out::println));
    }

    public static void show() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello Thread Trace");
    }
}
