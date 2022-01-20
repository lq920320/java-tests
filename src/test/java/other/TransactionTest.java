package other;

import com.transaction.TransactionEvent;
import org.junit.Test;

/**
 * @author zetu
 * @date 2022/1/18
 */
public class TransactionTest {


    @Test
    public void test1() {
        TransactionEvent event = new TransactionEvent();
        event.setEventType("abc");
        event.setRunnable(() -> {
            System.out.println("asdahsjdyasjhd");
        });

        event.getRunnable().run();
    }

}
