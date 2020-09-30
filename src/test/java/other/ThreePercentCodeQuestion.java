package other;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuqian
 * @date 2019/6/17  13:06
 * 3% 的代码问题
 */
public class ThreePercentCodeQuestion {
    /**
     * 1.Lock 锁的使用往往稍微不注意，可能导致死锁的问题。
     * <p>
     * <p>
     * 在使用阻塞等待获取锁的方式中，必须在 try 代码块之外，并且在加锁方法与 try 代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。
     * <p>
     * <p>
     * 如果在 lock 方法与 try 代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。如果 lock 方法在 try 代码块之内，可能由于其它方法抛出异常，导致在 finally代码块中，unlock 对未加锁的对象解锁，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），抛出 IllegalMonitorStateException 异常。在 Lock 对象的 lock方法实现中可能抛出 unchecked 异常。而在使用尝试机制来获取锁的方式中，比如 tryLock()，在进入业务代码块之前，必须先判断当前线程是否持有锁。
     * <p>
     * <p>
     * 锁的释放规则与锁的阻塞等待方式相同。Lock 对象的 unlock 方法在执行时，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），如果当前线程不持有锁，则抛出 IllegalMonitorStateException 异常。
     * <p>
     * 3.浮点数的比较问题。
     * <p>
     * <p>
     * 1-0.9=0.1是天经地义的，但在计算机的世界里，0.1恰恰是无法精确表示的一个小数，只有2的幂次倍小数才能够精确表示，如：0.5、0.25、0.125等。由于0.1是近似表达，在各种情形中的计算存在数位的取舍精度不一样，所以1-0.9未必等于0.9-0.8，所以浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用equals来判断。
     * <p>
     * <p>
     * 说明：浮点数采用“尾数+阶码”的编码方式，类似于科学计数法的“有效数字+指数”的表示方式。二进制无法精确表示大部分的十进制小数，具体原理参考《码出高效》。
     */

    @Test
    public void floatEqualTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        float c = 0.8f - 0.7f;
        float d = 0.7f - 0.6f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);


        System.out.println(Float.valueOf(0.1f));
        System.out.println(Float.valueOf("0.1"));

    }

    // 01
    @Test
    public void floatPrimitiveTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // the result: false
    }

    // 02
    @Test
    public void FloatWrapperTest() {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        System.out.println(a);
        System.out.println(b);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // the result: false
    }

    // 03
    @Test
    public void SwitchTest() {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
        // the result: nullException
    }

    // 04
    @Test
    public void BigDecimalTest() {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
        // the result:
        //        a: 0.1000000000000000055511151231257827021181583404541015625
        //        b: 0.1
    }

    // 05
    private final static Lock lock = new ReentrantLock();

    @Test
    public void LockTest() {
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        // the result:
    }
}
