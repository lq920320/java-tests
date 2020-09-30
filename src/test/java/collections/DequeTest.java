package collections;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liuqian
 * @date 2020/9/30 13:55
 */
public class DequeTest {

    @Test
    public void dequeTest() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("A");
        deque.add("B");
        deque.addFirst("01");

        System.out.println(deque.poll());

        for (String s : deque) {
            System.out.println(s);
        }

        System.out.println(deque);
    }
}
