package com.halsey.netty.sqldata;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangyaohai on 2017/9/21.
 */
public class LocalDit {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getWeekOfYears(String dateStr){
        LocalDateTime localDate=  LocalDateTime.parse(dateStr, dateTimeFormatter);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
        return  getWeekOfYear(date);
    }


    public static String getMonthOfYears(String dateStr){
        LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);
        String m = String.valueOf(localDate.getMonthValue());
        m = m.length() == 1?"0"+m:m;
        return new StringBuffer(String.valueOf(localDate.getYear())).append(String.valueOf(m)).toString();
    }

    public static String getDayOfYears(String dateStr){
        String m = getMonthOfYears(dateStr);
        LocalDate localDate = LocalDate.parse(dateStr, dateTimeFormatter);
        String d = String.valueOf(localDate.getDayOfMonth());
        d = d.length() == 1?"0"+d:d;
        return new StringBuffer(m).append(d).toString();
    }

    private static String getWeekOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        return new StringBuffer(String.valueOf(cal.get(Calendar.YEAR))).append(week).toString();
    }

}
