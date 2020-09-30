package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/7/1  17:50
 */
public class ThreadLocalTest {
    /**
     * 每个线程都有自己的共享变量
     * ThreadLocal 类主要解决的就是让每个线程绑定自己的值，可以将 ThreadLocal 类形象地比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据
     */


    public static ThreadLocal<String> t1 = new ThreadLocal<>();

    @Test
    public void threadLocalTest() {
        if (t1.get() == null) {
            System.out.println("为ThreadLocal类对象放入值： aaa");
            t1.set("aaa");
        }

        System.out.println(t1.get());
        System.out.println(t1.get());
    }

    private static ThreadLocalExt t2 = new ThreadLocalExt();

    @Test
    public void threadLocalTest2() {
        if (t2.get() == null) {
            System.out.println("从未放过值");
            t2.set("我的值");
        }
        System.out.println(t2.get());
        System.out.println(t2.get());
    }


    static public class ThreadLocalExt extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return "我是默认值 第一次 get 不再为 null";
        }
    }

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }

}
