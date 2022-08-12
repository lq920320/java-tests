package base;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 日期和时间测试用例 java.time.*
 *
 * @author zetu
 * @date 2022/8/11
 */
public class DateAndTimeTests {

    @Test
    public void calDifference() {
        LocalDate d1 = LocalDate.of(2017, 5, 1);
        LocalDate d2 = LocalDate.of(2017, 5, 18);
        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(days);
    }

    @Test
    public void dateAndTimeWithOffsetTest() {
        ZoneOffset zoneOffset = ZoneOffset.ofHours(2);
        OffsetDateTime dateTime = OffsetDateTime.of(2016, 7, 27, 7, 0, 0, 235, zoneOffset);
        System.out.println(dateTime);
        LocalDate localDate = LocalDate.of(2016, 7, 27);
        LocalTime localTime = LocalTime.of(7, 0, 0, 235);
        OffsetDateTime composition = OffsetDateTime.of(localDate, localTime, zoneOffset);
        System.out.println(composition);
        OffsetDateTime now = OffsetDateTime.now(); // Offset taken from the default ZoneId
        System.out.println(now);
        OffsetDateTime parsed = OffsetDateTime.parse("2016-07-27T07:00:00+02:00");
        System.out.println(parsed);
    }

    @Test
    public void operationTest() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDateTime anHourFromNow = LocalDateTime.now().plusHours(1);
        Long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(),
                LocalDate.now().plusDays(3)); // 3
        Duration duration = Duration.between(Instant.now(),
                ZonedDateTime.parse("2016-07-27T07:00:00+01:00[Europe/Stockholm]"));
        System.out.println(duration);
    }

    @Test
    public void instantTest() {
        Instant now = Instant.now();
        System.out.println(now); // 2022-08-11T08:45:48.734Z
        Instant epoch1 = Instant.ofEpochMilli(0);
        Instant epoch2 = Instant.parse("1970-01-01T00:00:00Z");
        System.out.println(ChronoUnit.MICROS.between(epoch1, epoch2)); // 0
    }

    @Test
    public void formatAndParseTest() {
        // 转化
        String pattern = "d-MM-yyyy HH:mm";
        DateTimeFormatter dtF1 = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ldp1 = LocalDateTime.parse("2014-03-25T01:30"), // 默认格式
                ldp2 = LocalDateTime.parse("15-05-2016 13:55", dtF1); // 自定义格式
        System.out.println(ldp1 + "\n" + ldp2); // 会按照默认格式打印

        // 格式化
        DateTimeFormatter dtF2 = DateTimeFormatter.ofPattern("EEE d, MMMM, yyyy HH:mm");
        DateTimeFormatter dtF3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime ldtf1 = LocalDateTime.now();
        System.out.println(ldtf1.format(dtF2) + "\n" + ldtf1.format(dtF3));
    }


    @Test
    public void methodTest() {
        // LocalDateTime
        SomeMethodsExamples.checkLocalDateTime();
        // LocalDate
        SomeMethodsExamples.checkLocalDate();
        // Clock
        SomeMethodsExamples.checkClock();
        // Instant
        SomeMethodsExamples.checkInstant();
        // Duration
        SomeMethodsExamples.checkDuration();
        // LocalTime
        SomeMethodsExamples.checkLocalTime();
        // ZonedDateTime
        SomeMethodsExamples.checkZonedDateTime();
    }
}
