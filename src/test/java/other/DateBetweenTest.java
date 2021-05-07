package other;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.text.ParseException;
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
