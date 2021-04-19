package other;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liuqian
 * @date 2019/6/25  17:36
 */
public class SubListTest {

    @Test
    public void sublistTest() {
        List<String> sourceList = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
            add("H");
        }};

        List<String> subList = sourceList.subList(2, 5);

        System.out.println("sourceList : " + sourceList);
        System.out.println("sourceList.subList(2, 5) 得到 List: ");
        System.out.println("subList : " + subList);

        subList.add("O");

        System.out.println("subList.add(O) 得到List ：");
        System.out.println("subList ： " + subList);
        System.out.println("sourceList ： " + sourceList);

        sourceList.add("I");
        System.out.println("sourceList.add(I) 得到List ：");
        System.out.println("sourceList ： " + sourceList);
        // 此处会抛 ConcurrentModificationException
        System.out.println("subList ： " + subList);
    }

    @Test
    public void failFastTest() {
        List<String> userNames = new CopyOnWriteArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        userNames.iterator();

//        for (String userName : userNames) {
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }
        userNames.removeIf(userName -> userName.equals("Hollis"));

        System.out.println(userNames);
    }

    @Test
    public void subListTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 95; i++) {
            list.add(i);
        }

        int batchNumber = 9;
        int totalSize = list.size();
        int quotient = totalSize / batchNumber;
        int remainder = totalSize % batchNumber;
        int scrollTimes = quotient;
        if (remainder > 0) {
            scrollTimes += 1;
        }
        for (int i = 0; i < scrollTimes; i++) {
            int fromIndex = i * batchNumber;
            int toIndex;
            if (i == scrollTimes - 1) {
                toIndex = totalSize;
            } else {
                toIndex = fromIndex + batchNumber;
            }
            List<Integer> batchList = list.subList(fromIndex, toIndex);
            System.out.println(JSON.toJSONString(batchList));
        }
    }
}
