package org.hong.thread.correspond;

import java.util.*;

/**
 * @author hong
 * @version v1.1
 * @ClassName: CaptureService
 * @Description: (模拟数据采集，控制正在运行的线程数，保证最大5个线程同时运行)
 * @date 2017/11/20
 */
public class CaptureService {

    private static final LinkedList<Control> CONTROLS = new LinkedList<>();

    private static final int MAX_WORKER = 5;

    // 所有采集汇总的记录数
    private static int sum = 0;

    public static void main(String[] args) {

        List<Thread> workers = new ArrayList<>();

        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10")
                .stream()
                .map(CaptureService::createCaptureThread).forEach(t -> {
            t.start();
            workers.add(t);
        });

        // main 线程等待所有自定义线程执行完成.
        workers.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("完成所有数据采集工作,获取到 %d 条记录.",sum);

    }

    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            Optional.of("线程 【" + Thread.currentThread().getName() + "]  准备开始进行数据采集").ifPresent(System.out::println);

            synchronized (CONTROLS) {
                while (CONTROLS.size() > MAX_WORKER) {
                    try {
                        // 放弃cpu 执行权，等待其他线程执行完毕唤醒.
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            sum += Math.random() * 100_0000;

            try {
                // 暂停10s ，模拟数据采集时间.
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of("线程 【" + Thread.currentThread().getName() + "]  准备数据采集完成").ifPresent(System.out::println);

            synchronized (CONTROLS) {
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }


        }, name);
    }


    private static class Control {

    }
}
