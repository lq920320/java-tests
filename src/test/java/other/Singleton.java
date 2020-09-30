package other;

/**
 * @author liuqian
 * @date 2019/4/1  16:37
 * 单例模式的 DCL（双重检验锁） 写法
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    // 此处分三步执行
                    // 1. 为 uniqueInstance 分配内存空间
                    // 2. 初始化 uniqueInstance
                    // 3. 将 uniqueInstance 指向分配的内存地址
                    // 而加了 volatile 之后会防止 JVM 进行指令重排（多线程环境下）
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
