package org.hong.thread.customlock;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @ClassName: LockTest
 * @Description: (自定义锁测试.)
 * @author hong
 * @date 2017/11/25
 * @version v1.1
 */
public class LockTest {

    public static void main(String[] args) {

        final BooleanLock booleanLock =new BooleanLock();

        Stream.of("T1","T2","T3","T4").forEach(name->{
            new Thread(()->{
                try {

                    booleanLock.lock(3000);

                    Optional.of(Thread.currentThread().getName() + " have the lock Monitor")
                            .ifPresent(System.out::println);

                    // 执行工作块.
                    work(booleanLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Lock.TimeOutException e) {
                    e.printStackTrace();
                }
            },name).start();
        });

    }

    private static void work(BooleanLock booleanLock) throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is Working...")
                .ifPresent(System.out::println);
        Thread.sleep(2_000);
        booleanLock.unlock();
    }
}
