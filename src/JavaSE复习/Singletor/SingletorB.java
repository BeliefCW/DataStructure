package JavaSE复习.Singletor;

public class SingletorB {
    private static SingletorB singletorB = new SingletorB();
    private SingletorB(){}
    public static SingletorB getSingletorB(){
        return singletorB;
    }
}
