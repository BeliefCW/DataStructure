package JavaSE复习.JUC.JUC_Tools;
/**
 * 应用场景：运动员跑步比赛时，裁判手里的秒表一定是在运动员都到达终点时候才停止
 * 这时候，我们可以假设裁判为主线程，运动员为子线程，即当所有子线程执行结束之后主线成才可以结束
 * 四大工具类--闭锁--CountDownLatch
 * 每个CountDownLatch对象的计数器减为0时不可以在恢复原值
 * 调用await()方法的线程会一直阻塞，直到其他线程执行完毕，也就是CountDownLatch的计数器减为0
 * public CountDownLatch(int count)-->传入计数器
 * countDown() 减去计数器的方法
 */

import java.util.concurrent.CountDownLatch;

class CountDown implements Runnable{
    //传入CountDownLatch对象
    private CountDownLatch countDownLatch;

    public CountDown(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行任务");
        //此方法为减去计数器的方法
        countDownLatch.countDown();
    }
}
public class CountDownLatchTest {
    public static void main(String[] args) {
        //启动三个子线程，假设为三个运动员
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread thread1 = new Thread(new CountDown(countDownLatch),"A");
        thread1.start();
        Thread thread2 = new Thread(new CountDown(countDownLatch),"B");
        thread2.start();
        Thread thread3 = new Thread(new CountDown(countDownLatch),"C");
        thread3.start();
        try {
            //调用await()方法的线程，会一直阻塞，直到计数器减为0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有子线程执行任务结束");
    }
}