package other;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    @Test
    public void transTest() throws ParseException {
        String dateStr1 = "2021-08-27";
        String dateStr2 = "2021-08-01";
        String dateTimeStr1 = "2021-08-05 11:45:32";
        String dateTimeStr2 = "2021-08-10 10:45:32";

        Date date1 = DateUtils.parseDate(dateStr1, "yyyy-MM-dd");
        Date date2 = DateUtils.parseDate(dateStr2, "yyyy-MM-dd");
        Date dateTime1 = DateUtils.parseDate(dateTimeStr1, "yyyy-MM-dd HH:mm:ss");
        Date dateTime2 = DateUtils.parseDate(dateTimeStr2, "yyyy-MM-dd HH:mm:ss");

        long start0 = System.currentTimeMillis();
        ZoneId zoneId = ZoneId.systemDefault();
        // 万万没想到，获取时区居然这么耗时
        System.out.println("获取zoneId耗时：" + (System.currentTimeMillis() - start0) + "ms");

        long start1 = System.currentTimeMillis();
        System.out.println(date1.toInstant().atZone(zoneId).toLocalDate());
        System.out.println("date1转换localDate耗时：" + (System.currentTimeMillis() - start1) + "ms");

        long start2 = System.currentTimeMillis();
        System.out.println(date2.toInstant().atZone(zoneId).toLocalDateTime());
        System.out.println("date2转换localDateTime耗时：" + (System.currentTimeMillis() - start2) + "ms");

        long start3 = System.currentTimeMillis();
        System.out.println(dateTime1.toInstant().atZone(zoneId).toLocalDateTime());
        System.out.println("dateTime1转换localDateTime耗时：" + (System.currentTimeMillis() - start3) + "ms");

        long start4 = System.currentTimeMillis();
        System.out.println(dateTime2.toInstant().atZone(zoneId).toLocalDateTime());
        System.out.println("dateTime2转换localDateTime耗时：" + (System.currentTimeMillis() - start4) + "ms");
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

    @Test
    public void dateFormatTest() {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.toInstant());
        System.out.println(ZoneId.systemDefault());
        System.out.println(now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
    }
}
