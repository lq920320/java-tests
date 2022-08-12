package base;

import java.time.*;
import java.util.TimeZone;

public class SomeMethodsExamples {

    /**
     * {@link LocalDateTime} 包含的一些方法
     */
    public static void checkLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date time using static now() method ::: >>> "
                + localDateTime);
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS
                .get("AET")));
        System.out
                .println("LOCAL TIME USING now(ZoneId zoneId) method ::: >>>>"
                        + ldt1);
        LocalDateTime ldt2 = LocalDateTime.now(Clock.system(ZoneId
                .of(ZoneId.SHORT_IDS.get("PST"))));
        System.out
                .println("Local TIME USING now(Clock.system(ZoneId.of())) ::: >>>> "
                        + ldt2);
        System.out
                .println("Following is a static map in ZoneId class which has mapping of short timezone names to their Actual timezone names");
        System.out.println(ZoneId.SHORT_IDS);
    }

    /**
     * {@link LocalDate} 包含的一些方法
     */
    public static void checkLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println("Gives date without Time using now() method. >> "
                + localDate);
        LocalDate localDate2 = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
        System.out
                .println("now() is overridden to take ZoneID as parameter using this we can get the same date under different timezones. >> "
                        + localDate2);
    }

    /**
     * 抽象类 {@link Clock} 包含的一些方法。
     * Clock 可以用于表示带有时区 {@link TimeZone} 的时间
     */
    public static void checkClock() {
        Clock clock = Clock.systemUTC();
        // 根据 ISO 8601 表示时间
        System.out.println("Time user Clock class: " + clock.instant());
    }

    /**
     * {@link Instant} 包含的方法
     */
    public static void checkInstant() {
        Instant instant = Instant.now();
        System.out.println("Instant using now() method :: " + instant);

        Instant ins1 = Instant.now(Clock.systemUTC());
        System.out.println("Instant using now(Clock clock) :: " + ins1);
    }

    /**
     * 检查 {@link Duration} 类的方法
     */
    public static void checkDuration() {
        // toString() 方法会根据 ISO-8601 标准将 duration 转换为 PTnHnMnS 格式
        // 如果某个属性为 0 的话就忽略。

        // P 是放置在期间表达式开始处的 duration 符号（历史上称为“period”）
        // Y 是年数值之后的年份符号
        // M 是月份数之后的月份符号
        // W 是周数值之后的周符号
        // D 是天数值之后的日期符号
        // T 是表示的时间分量之前的时间符号
        // H 是小时数值之后的小时符号
        // M 是分钟数之后的分钟符号
        // S 是秒数值之后的秒符号
        System.out.println(Duration.ofDays(2));
    }

    /**
     * 显示不带日期的当地时间。它不存储或表示日期和时间。
     * 相反，它是时间的代表，就像墙上的时钟。
     */
    public static void checkLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime :: " + localTime);
    }

    /**
     * ISO-8601 标准格式，带有详细时区的日期时间，
     */
    public static void checkZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
        System.out.println(zonedDateTime);
    }
}
