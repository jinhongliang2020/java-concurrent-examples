package org.hong.thread.customlock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * @author hong
 * @version v1.1
 * @ClassName: BooleanLock
 * @Description: (自定义Lock 实现.)
 * @date 2017/11/25
 */
public class BooleanLock implements Lock {


    // 判断当前是否有线程持有锁.
    private boolean hasLock;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    public BooleanLock() {
        this.hasLock = false;
    }


    @Override
    public synchronized void lock() throws InterruptedException {
        while (hasLock) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.hasLock = true;
        this.currentThread = Thread.currentThread();
        Optional.of(Thread.currentThread().getName()+" 拿到锁.").ifPresent(System.out::println);
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0)
            lock();
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (hasLock) {
            if (hasRemaining <= 0)
                throw new TimeOutException(Thread.currentThread().getName() + "等待锁已超时.");
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime - System.currentTimeMillis();
        }

        blockedThreadCollection.remove(Thread.currentThread());
        this.hasLock = true;
        this.currentThread = Thread.currentThread();
        Optional.of(Thread.currentThread().getName()+" 拿到锁.").ifPresent(System.out::println);

    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            this.hasLock = false;
            this.notifyAll();
            Optional.of(Thread.currentThread().getName() + " 释放锁.").ifPresent(System.out::println);
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
