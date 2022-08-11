package base;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期类相关测试
 *
 * @author zetu
 * @date 2022/8/10
 */
public class DateTests {

    @Test
    public void utilDateToSqlDateTest() {
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date is : " + utilDate);
        java.sql.Date sqlDate = convert(utilDate);
        System.out.println("java.sql.Date is : " + sqlDate);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        System.out.println("dateFormated date is : " + df.format(utilDate));
    }

    private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @Test
    public void formatTest() {
        // 定义要使用的格式
        String formatString = "yyyy/MM/dd hh:mm.ss";

        // 获取当前的日期对象
        Date date = Calendar.getInstance().getTime();

        // 创建一个格式化工具
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);

        // 格式日期
        String formattedDate = simpleDateFormat.format(date);

        // 打印
        System.out.println(formattedDate);

        // 一行代码流
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss").format(Calendar.getInstance().getTime()));
    }

    @Test
    public void localDateAndDateTimeTest() {
        // 创建一个默认对象，当前日期
        LocalDate lDate = LocalDate.now();
        // 由一些参数来创建
        lDate = LocalDate.of(2022, 8, 1);
        // 由一个字符串创建
        lDate = LocalDate.parse("2022-08-01");

        // 由时区创建
        LocalDate.now(ZoneId.systemDefault());
        // 创建一个默认对象，当前日期时间
        LocalDateTime lDateTime = LocalDateTime.now();
        // 由一些参数来创建
        lDateTime = LocalDateTime.of(2017, 12, 15, 11, 30);
        // 由一个字符串创建
        lDateTime = LocalDateTime.parse("2017-12-05T11:30:30");
        // 由时区创建
        LocalDateTime.now(ZoneId.systemDefault());
// ===============================================
        // date与localDate互相转换
        Date date = Date.from(Instant.now());
        ZoneId defaultZoneId = ZoneId.systemDefault();
        // Date 转 LocalDate
        LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
        // LocalDate 转 Date
        date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

// ===============================================
        // date与localDateTime互相转换
        // Date 转 LocalDateTime
        LocalDateTime localDateTime = date.toInstant().atZone(defaultZoneId).toLocalDateTime();
        // LocalDateTime 转 Date
        Date out = Date.from(localDateTime.atZone(defaultZoneId).toInstant());
    }

    @Test
    public void convertStringTest() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy"); // 在这里指定格式
        System.out.println(dateFormat.format(today)); // 10-八月-22

        dateFormat.applyPattern("dd-MM-yyyy");
        System.out.println(dateFormat.format(today)); // 10-08-2022
        dateFormat.applyPattern("yyyy'年'M'月'd'日' EEEE");
        System.out.println(dateFormat.format(today)); // 10-08-2022 16:48:08 星期三
    }

    @Test
    public void localTimeTest() {
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
//
//time.plusMinutes(1);
//time.getMinute();
//time.minusMinutes(1);
        LocalTime lTime = LocalTime.now();
        Instant instant = lTime.atDate(LocalDate.of(2022, 8, 1)).
                atZone(ZoneId.systemDefault()).toInstant();
        Date time = Date.from(instant);
    }


    /**
     * Calendar, Date, and LocalDate
     * 小于 java8的比较
     * before, after, compareTo and equals methods
     */
    @Test
    public void compareTest() {
        // Use of Calendar and Date objects
        final Date today = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
        Date birthdate = calendar.getTime();
        final Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
        Date sameBirthdate = calendar2.getTime();

        // Before example
        System.out.printf("Is %1$tF before %2$tF? %3$b%n", today, birthdate, today.before(birthdate));
        System.out.printf("Is %1$tF before %1$tF? %3$b%n", today, today,
                today.before(today));
        System.out.printf("Is %2$tF before %1$tF? %3$b%n", today, birthdate, birthdate.before(today));

        // After example
        System.out.printf("Is %1$tF after %2$tF? %3$b%n", today, birthdate, birthdate.after(today));
        System.out.printf("Is %1$tF after %1$tF? %3$b%n", today, birthdate, today.after(today));
        System.out.printf("Is %2$tF after %1$tF? %3$b%n", today, birthdate, birthdate.after(today));

        // Compare example
        System.out.printf("Compare %1$tF to %2$tF: %3$d%n",
                today, birthdate, today.compareTo(birthdate));
        System.out.printf("Compare %1$tF to %1$tF: %3$d%n",
                today, birthdate, today.compareTo(today));
        System.out.printf("Compare %2$tF to %1$tF: %3$d%n",
                today, birthdate, birthdate.compareTo(today));

        // Equal example
        System.out.printf("Is %1$tF equal to %2$tF? %3$b%n",
                today, birthdate, today.equals(birthdate));
        System.out.printf("Is %1$tF equal to %2$tF? %3$b%n",
                birthdate, sameBirthdate, birthdate.equals(sameBirthdate));
        System.out.printf("Because birthdate.getTime() -> %1$d is different from sameBirthdate.getTime() -> %2$d, there are milliseconds! %n",
                birthdate.getTime(), sameBirthdate.getTime());

        // Clear ms from calendars
        calendar.clear(Calendar.MILLISECOND);
        calendar2.clear(Calendar.MILLISECOND);
        birthdate = calendar.getTime();
        sameBirthdate = calendar2.getTime();
        System.out.printf("Is %1$tF equal to %2$tF after clearing ms? %3$b%n",
                birthdate, sameBirthdate, birthdate.equals(sameBirthdate));

    }

    /**
     * Calendar, Date, and LocalDate
     * java8 之后的比较
     * isBefore, isAfter, compareTo and equals methods
     */
    @Test
    public void compare2Test() {
        // Use of LocalDate
        final LocalDate now = LocalDate.now();
        final LocalDate birthdate2 = LocalDate.of(2012, 6, 30);
        final LocalDate birthdate3 = LocalDate.of(2012, 6, 30);
        // Hours, minutes, second and nanoOfSecond can also be configured with another class LocalDateTime.
        // LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);

        // isBefore example
        System.out.printf("Is %1$tF before %2$tF? %3$b%n", now, birthdate2, now.isBefore(birthdate2));
        System.out.printf("Is %1$tF before %1$tF? %3$b%n", now, birthdate2, now.isBefore(now));
        System.out.printf("Is %2$tF before %1$tF? %3$b%n", now, birthdate2, birthdate2.isBefore(now));

        // isAfter example
        System.out.printf("Is %1$tF after %2$tF? %3$b%n", now, birthdate2, now.isAfter(birthdate2));
        System.out.printf("Is %1$tF after %1$tF? %3$b%n", now, birthdate2, now.isAfter(now));
        System.out.printf("Is %2$tF after %1$tF? %3$b%n", now, birthdate2, birthdate2.isAfter(now));

        // compareTo example
        System.out.printf("Compare %1$tF to %2$tF %3$d%n", now, birthdate2, now.compareTo(birthdate2));
        System.out.printf("Compare %1$tF to %1$tF %3$d%n", now, birthdate2, now.compareTo(now));
        System.out.printf("Compare %2$tF to %1$tF %3$d%n", now, birthdate2, birthdate2.compareTo(now));

        // equals example
        System.out.printf("Is %1$tF equal to %2$tF? %3$b%n", now, birthdate2, now.equals(birthdate2));
        System.out.printf("Is %1$tF to %2$tF? %3$b%n", birthdate2, birthdate3, birthdate2.equals(birthdate3));

        // isEqual example
        System.out.printf("Is %1$tF equal to %2$tF? %3$b%n", now, birthdate2, now.isEqual(birthdate2));
        System.out.printf("Is %1$tF to %2$tF? %3$b%n", birthdate2, birthdate3, birthdate2.isEqual(birthdate3));
    }

    @Test
    public void parseTest() throws ParseException {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String dateStr = "2022年8月1日 星期一"; // 输入String
        Date date = dateFormat.parse(dateStr);
        System.out.println(date); // Mon Aug 01 00:00:00 CST 2022
    }

    @Test
    public void formatWithZoneTest() {
        Date date = new Date();
        // 打印默认时区
        System.out.println(TimeZone.getDefault().getDisplayName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 注意：时区没有在 format 中设置
        // 打印原始时区的日期
        System.out.println(sdf.format(date));
        // 在伦敦的当前时间
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(sdf.format(date));
    }


}
