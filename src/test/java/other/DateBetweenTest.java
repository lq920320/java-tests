package other;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zetu
 * @date 2021/5/7
 */
public class DateBetweenTest {

    @Test
    public void dateBetween() throws ParseException {
        String a = "2021-04-17";
        String b = "2021-05-09";

        Date aDate = DateUtils.parseDate(a, "yyyy-MM-dd");
        Date bDate = DateUtils.parseDate(b, "yyyy-MM-dd");

        System.out.println(differentDays(aDate, bDate));
    }

    @Test
    public void dateBetweenMonthTest() throws ParseException {
        String a = "2021-04-01 00:00:00";
        String b = "2021-07-01 23:59:59";

        String c = "2021-04-25 00:00:00";
        String d = "2021-07-23 23:59:59";

        Date aDate = DateUtils.parseDate(a, "yyyy-MM-dd HH:mm:ss");
        Date bDate = DateUtils.parseDate(b, "yyyy-MM-dd HH:mm:ss");
        Date cDate = DateUtils.parseDate(c, "yyyy-MM-dd HH:mm:ss");
        Date dDate = DateUtils.parseDate(d, "yyyy-MM-dd HH:mm:ss");

        System.out.println("======================= a ====== b ============");
        System.out.println(betweenMonth(aDate, bDate, true));
        System.out.println(betweenMonth(aDate, bDate, false));
        System.out.println(DateUtil.between(aDate, bDate, DateUnit.WEEK));
        System.out.println(DateUtil.between(aDate, bDate, DateUnit.DAY));

        Temporal temporal1 = LocalDateTime.parse(a, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Temporal temporal2 = LocalDateTime.parse(b, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println(ChronoUnit.MONTHS.between(temporal1, temporal2));

        System.out.println("======================= c ====== d ============");
        System.out.println(betweenMonth(cDate, dDate, true));
        System.out.println(betweenMonth(cDate, dDate, false));
        System.out.println(DateUtil.between(cDate, dDate, DateUnit.WEEK));
        System.out.println(DateUtil.between(cDate, dDate, DateUnit.DAY));

//        Temporal temporal3 = LocalDateTime.parse(c, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Temporal temporal4 = LocalDateTime.parse(d, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Temporal temporal3 = cDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Temporal temporal4 = dDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(temporal3);
        System.out.println(temporal4);

        System.out.println(ChronoUnit.MONTHS.between(temporal3, temporal4));

    }

    /**
     * 两个日期相隔多少个月
     *
     * @param aDate
     * @param bDate
     */
    private long betweenMonth(Date aDate, Date bDate, boolean isReset) {
        Calendar beginCal = DateUtil.calendar(aDate);
        Calendar endCal = DateUtil.calendar(bDate);
        int betweenYear = endCal.get(Calendar.YEAR) - beginCal.get(Calendar.YEAR);
        int betweenMonthOfYear = endCal.get(Calendar.MONTH) - beginCal.get(Calendar.MONTH);
        int result = betweenYear * 12 + betweenMonthOfYear;
        if (!isReset) {
            endCal.set(Calendar.YEAR, beginCal.get(Calendar.YEAR));
            endCal.set(Calendar.MONTH, beginCal.get(Calendar.MONTH));
            long between = endCal.getTimeInMillis() - beginCal.getTimeInMillis();
            if (between < 0L) {
                return result - 1;
            }
        }

        return result;
    }


    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            // 不同年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    // 闰年
                    timeDistance += 366;
                } else {
                    // 不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else {
            // 同一年
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }
}
