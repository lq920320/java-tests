package other;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author liuqian
 * @date 2019/4/11  10:50
 */
public class DateFormatTest {

    @Test
    public void dateFormat() {
        String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        System.out.println(dateStr);
        System.out.println(getAfterOneDay(dateStr));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() / 1000);
    }

    private String getAfterOneDay(String today) {
        try {
            String[] parsePatterns = {"yyyy-MM-dd"};
            return DateFormatUtils.format(DateUtils.addDays(DateUtils.parseDate(today, parsePatterns), 1), "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String[] date = {"2019-05-13", "2019-05-12", "2019-05-11", "2019-05-10", "2019-05-01", "2019-05-02"};

    @Test
    public void simpleDateFormatTest() {
        for (int i = 0; i < date.length; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (sdf) {
                            String str1 = date[temp];
                            String str2 = sdf.format(sdf.parse(str1));
                            System.out.println(Thread.currentThread().getName() + "," + str1 + "," + str2);
                            if (!str1.equals(str2)) {
                                throw new RuntimeException(Thread.currentThread().getName() + ", Excepted " + str1 + ", but got " + str2);
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("parse failed", e);
                }
            }).start();
        }
    }


    @Test
    public void datetimeFormatterTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2019-05-13", formatter);
        System.out.println(date);
        System.out.println(formatter.format(date));
    }


    @Test
    public void datetimeFormatterTest2() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse("2019-05-13 16:00", formatter);
        System.out.println(date);
        System.out.println(formatter.format(date));
    }
}
