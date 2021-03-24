package collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zetu
 * @date 2021/3/24
 */
public class TreeSetTest {

    @Test
    public void treeSetTest() {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");
        treeSet.add("D");
        treeSet.add("E");
        // [A, B, C, D, E]
        System.out.println(treeSet);

        ascIteratorThroughIterator(treeSet);
        descIteratorThroughIterator(treeSet);
    }

    /**
     * 顺序遍历TreeSet
     *
     * @param set
     */
    public static void ascIteratorThroughIterator(TreeSet<String> set) {
        System.out.print("\n ---- Ascend Iterator ----\n");
        for (String s : set) {
            System.out.printf("asc : %s\n", s);
        }
    }

    /**
     * 逆序遍历TreeSet
     *
     * @param set
     */
    public static void descIteratorThroughIterator(TreeSet<String> set) {
        System.out.print("\n ---- Descend Iterator ----\n");
        for (Iterator<String> iter = set.descendingIterator(); iter.hasNext(); ) {
            System.out.printf("desc : %s\n", iter.next());
        }
    }
}
