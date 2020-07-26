package JavaSE复习.JUC.Lock_死锁;

/**
 * 死锁产生的四个原因，缺一不可
 * 1.互斥：同一个资源在任意时刻只能被一个线程占有
 * 2.占有且等待：如：线程A占有笔资源等待线程B的本子资源，线程B占有本子资源等待线程A的笔资源，
 * 3.不可抢占：其他线程无法抢占线程一占有的资源
 * 4.互相等待：线程A等待线程B释放资源，线程B等待线程A释放资源
 *
 * synchronized无法解决此问题，引入了Lock
 *
 * 死锁的现象：程序出现"假死现象"
 * 解决：破坏四条中任意一条即可
 */
class Pen{}
class Book{}
public class Test {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Book book = new Book();
        Thread penThread = new Thread(()->{

           synchronized (pen){
               System.out.println("我有笔");
               synchronized (book){
                   System.out.println("请把本子给我");
               }
           }
        });
        Thread bookThread = new Thread(()->{
            synchronized (book){
                System.out.println("我有本子");
                synchronized (pen){
                    System.out.println("请把本子给我");
                }
            }
        });
        penThread.start();
        bookThread.start();
    }
}