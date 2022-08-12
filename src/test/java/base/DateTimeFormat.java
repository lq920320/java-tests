package base;

import java.time.*;
import java.time.format.*;

class DateTimeFormat {

    public static void main(String[] args) {
        // 转化解析
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
}
