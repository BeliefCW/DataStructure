package JavaSE复习.JUC.JUC_Tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 工具类--循环栅栏-->CyclicBarrier
 * 循环：每个CyclicBarrier对象的计数器可以重复使用,其中的几个重要方法使用
 *
 * public CycliBarrier(int count,Runnable barrierAction)-->
 * 所有子线程在调用await()方法后将计数器减为0，任意挑选一个线程执行barrierAction任务
 *
 * public int await() throws InterruptedException, BrokenBarrierException
 * 子线程调用await()方法，会进入阻塞状态，并且每当一个子线程调用，CyclicBarrier对象的计数器
 * 减一，直到减为0时，所有子线程恢复执行
 */
class Cyclic implements Runnable{
    private CyclicBarrier cyclicBarrier;
    public Cyclic(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在写入数据");
        try {
            TimeUnit.SECONDS.sleep(2);
            //相当于一堵墙，每个线程执行到此时，会被阻塞
            cyclicBarrier.await();
            System.out.println("所有线程写入数据完毕"+Thread.currentThread().getName()+"开始恢复执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程为"+Thread.currentThread().getName());
            }
        });
        //启动三个线程
        for (int i = 0; i < 3; i++){
            new Thread(new Cyclic(cyclicBarrier),"写入线程"+i).start();
        }
    }
}
