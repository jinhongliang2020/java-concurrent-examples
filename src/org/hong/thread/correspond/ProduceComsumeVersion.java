package org.hong.thread.correspond;

/**
 * @ClassName: ProduceComsumeVersion
 * @Description: (生产者消费者实例.)
 * @author hong
 * @date 2017/11/19
 * @version v1.1
 */
public class ProduceComsumeVersion {

    private int index=1;

    final Object LOCK =new Object();


    private volatile  boolean isProduced = false;

    // 生产者
    public void produce(){
        synchronized (LOCK){
            if(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                index++;
                System.out.println("P->"+index);
                isProduced =true;
                LOCK.notify();
            }
        }
    }


    // 消费者
    public void consume(){
        synchronized (LOCK){
            if(isProduced){
                System.out.println("C->"+index);
                isProduced=false;
                LOCK.notify();
            }else{
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // 注：在单生产者 消费者的情况下，使用notify 不会有问题，因为用户唤醒的是对方线程
    //    但在多生产者、消费者的时候，情况就可能不是那样了，会出现假死现象.
    //    因为notity 不会指定具体唤醒哪一个线程,就有可能照成所有的线程都会进入wait状态.
    public static void main(String[] args) {
        ProduceComsumeVersion produceComsumeVersion =new ProduceComsumeVersion();
        new Thread("P"){
            @Override
            public void run() {
                while (true){
                    produceComsumeVersion.produce();
                }
            }
        }.start();

        new Thread("C"){
            @Override
            public void run() {
                while (true){
                    produceComsumeVersion.consume();
                }
            }
        }.start();
    }
}
