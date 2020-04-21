package JavaSE复习.JUC.JUC_Tools;



class MyThread implements Runnable {
    private int ticket = 10 ; // 一共十张票
    @Override
    public void run() {
        //while(this.ticket>0) { // 还有票
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // 模拟网络延迟
            System.out.println(Thread.currentThread().getName()+",还有" +this.ticket --
                    +" 张票");
        //}
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread,"A").start();
        new Thread(myThread,"B").start();
        new Thread(myThread,"C").start();

    }
}
