package org.hong.thread.stop_thread;


/**
 * @Description: (使用状态控制的方式停止线程运行.)
 * @author hong
 * @date 2017/11/17
 * @version v1.1
 */
public class ThreadCloseState {

    private static  class  Worker extends  Thread{
        private volatile boolean state = true;

        @Override
        public void run() {
                // 使用状态机制控制线程内容运行
                // 这种方式有个问题，运行内容如果一直卡在那，压根不会去判断while(state) 的值
                while (state){
                    System.out.println(Thread.currentThread().getName()+"...run!");
                }
        }

        public void shutdown(){this.state=false;}

    }


    public static void main(String[] args) {

        Worker worker =new Worker();
        worker.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止线程.
        worker.shutdown();
    }
}
