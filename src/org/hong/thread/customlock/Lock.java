package org.hong.thread.customlock;

import java.util.Collection;

/**
 * @ClassName: Lock
 * @Description: (自定义Lock接口.)
 * @author hong
 * @date 2017/11/25
 * @version v1.1
 */
public interface Lock {

    /**
     * 自定义超时异常.
      */
    class TimeOutException extends Exception{

        public  TimeOutException(String message){
            super(message);
        }
    }


    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
