package JavaSE复习.Singletor;

//懒汉式单例
//1.假设线程1进来了
//a.堆上开辟空间
//b.属性初始化
//C.栈上开辟空间指向堆内存
//如果没有volatile的可见性，和禁止指令重排，会导致a,b,c执行顺序有问题，如果这时候线程二进入第八行代码
//而线程1先执行了c，则这时候就会直接返回，导致属性还没有初始化
public class SingletorA {
    private static volatile SingletorA singletorA;
    private SingletorA(){}
    public SingletorA getSingletorA(){
        if(singletorA == null){
            synchronized (SingletorA.class){
                if(singletorA == null){
                    singletorA = new SingletorA();
                }
            }
        }
        return singletorA;
    }
}
