package org.hong.thread.correspond;

import java.util.stream.Stream;

/**
 * @author hong
 * @version v1.1
 * @ClassName: ProduceComsumeVersion
 * @Description: (生产者消费者实例.)
 * @date 2017/11/19
 */
public class ProduceComsumeVersion2 {

    private int index = 1;

    final Object LOCK = new Object();


    private volatile boolean isProduced = false;

    // 生产者
    public void produce() {
        synchronized (LOCK) {
            while (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            index++;
            System.out.println("P->" + index);
            isProduced = true;
            LOCK.notifyAll();
        }
    }


    // 消费者
    public void consume() {
        synchronized (LOCK) {
            while (!isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("C->" + index);
            isProduced = false;
            LOCK.notifyAll();
        }
    }

    // 多生产者消费者改造点：
    // 1.使用notityAll() 唤醒所有线程
    // 2.判断是否生产时，使用while 替换if ，防止同时唤醒后，多生产多消费的情况出现.
    public static void main(String[] args) {
        ProduceComsumeVersion2 produceComsumeVersion = new ProduceComsumeVersion2();

        Stream.of("P1", "P2", "P3").forEach(name ->
                new Thread(name) {
                    @Override
                    public void run() {
                        while (true) {
                            produceComsumeVersion.produce();
                        }
                    }
                }.start()
        );

        Stream.of("C1", "C2", "C3").forEach(name ->
                new Thread(name) {
                    @Override
                    public void run() {
                        while (true) {
                            produceComsumeVersion.consume();
                        }
                    }
                }.start()
        );
    }
}
