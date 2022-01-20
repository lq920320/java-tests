package other;

import org.junit.Test;

import java.awt.geom.Point2D;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static sun.nio.cs.Surrogate.is;

/**
 * Java8 stream 一些其他用法
 *
 * @author zetu
 * @date 2022/1/20
 */
public class CoolStreamTest {

    @Test
    public void fibonacci() {
        // 使用迭代打印，斐波那契数列
        Stream.iterate(new BigInteger[]{BigInteger.ONE, BigInteger.ONE},
                        p -> new BigInteger[]{p[1], p[0].add(p[1])})
                .limit(100)
                .forEach(p -> System.out.println(p[0]));
    }


    private static double calc(List<Integer> ints) {
        // 临时中间集合
        List<Point2D> point2DList = new ArrayList<>();
        for (Integer i : ints) {
            point2DList.add(new Point2D.Double((double) i % 3, (double) i / 3));
        }
        // 临时变量,纯粹是为了获得最后结果需要的中间变量
        double total = 0;
        int count = 0;

        for (Point2D point2D : point2DList) {
            // 过滤
            if (point2D.getY() > 1) {
                // 算距离
                double distance = point2D.distance(0, 0);
                total += distance;
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }

    @Test
    public void stream() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // 平均距离
        double average = calc(ints);
        double streamResult = ints.stream()
                .map(i -> new Point2D.Double((double) i % 3, (double) i / 3))
                .filter(point -> point.getY() > 1)
                .mapToDouble(point -> point.distance(0, 0))
                .average()
                .orElse(0);
        // 如何用一行代码来实现,比较一下可读性
        System.out.println(average);
        System.out.println(streamResult);
    }


}
