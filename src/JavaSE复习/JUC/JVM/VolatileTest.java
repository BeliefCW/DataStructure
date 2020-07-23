package JavaSE复习.JUC.JVM;

public class VolatileTest {
    private volatile int num = 0;
    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10;i++){
            threads[i] = new Thread(()->{
                for(int j = 0; j < 100; j++){
                    //不满足原子性
                    volatileTest.num++;
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2){
            //让主线程交出CPu
            Thread.yield();
        }
        System.out.println(volatileTest.num);
    }
}

