package JavaSE复习.Singletor;

//懒汉式单例
public class Test {
    private volatile static Test test;

    private Test(){}//构造方法私有化
    public static Test getTest(){
        if(test == null){
            synchronized (Test.class){
                if(test == null){
                    test = new Test();
                }
            }

        }
        return test;
    }
}
