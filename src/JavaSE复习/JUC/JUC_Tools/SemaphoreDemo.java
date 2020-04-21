package JavaSE复习.JUC.JUC_Tools;

/**
 *Semaphore翻译成字⾯意思为 信号量，Semaphore可以控同时访问的线程个数，通过 acquire() 获取
 * ⼀个许可，如果没有就等待，⽽ release() 释放⼀个许可。
 *
 * Semaphore类中⽐较重要的⼏个⽅法，⾸先是acquire()、release()⽅法：
 * //获取⼀个许可
 * public void acquire() throws InterruptedException { }
 * //获取permits个许可
 * public void acquire(int permits) throws InterruptedException { }
 * //释放⼀个许可
 * public void release() { }
 * //释放permits个许可
 * public void release(int permits) { }
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class SemaphoreTask implements Runnable{
    private int num;
    private Semaphore semaphore;
    public SemaphoreTask(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("⼯⼈"+this.num+"占⽤⼀台设备在⽣产");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("⼯⼈"+this.num+"释放出本设备");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        int worker = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0;i < worker;i++) {
            new Thread(new SemaphoreTask(i,semaphore)).start();
        }
    }
}