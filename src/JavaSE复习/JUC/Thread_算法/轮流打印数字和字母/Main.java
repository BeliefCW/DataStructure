package JavaSE复习.JUC.Thread_算法.轮流打印数字和字母;

/**
 * 使用一个线程打印“1-52”
 * 使用一个线程打印“A-Z”
 * 交替打印12A34B56C....
 */
class  Print{
    boolean flag = true;
    private int count = 1;
     //打印数字
    public synchronized void printNum(){
        if(flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(2*count-1);
        System.out.println(2*count);
        flag = false;
        notify();

    }
    //打印字母
    public synchronized void printChar(){
        if(flag == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println((char)('A'+count-1));
        flag = true;
        count++;
        notify();
    }
}

public class Main {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            for(int i = 0; i < 26; i++){
                print.printNum();
            }
        }).start();

        new Thread(()->{
            for(int i = 0; i < 26; i++){
                print.printChar();
            }
        }).start();
    }
}
