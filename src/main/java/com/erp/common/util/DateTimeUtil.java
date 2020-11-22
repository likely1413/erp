package com.erp.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public class DateTimeUtil {

    /**
     * 把时间字符串转换成 LocalDateTime 时间对象并返回
     *
     * @param timeString
     * @return LocalDateTime
     */
    public static LocalDateTime parseTimeString(String timeString) {
        return LocalDateTime.parse(timeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取当前日期字符串
     *
     * @return yyyy年MM月dd日
     */
    public static String getNowOfString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }


    /**
     * 获取当前日期时间字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeToString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 把日期字符串转换成 yyyy年MM月dd日
     *
     * @param dateString
     * @return yyyy年MM月dd日
     */
    public static String stringConvert(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.CHINA))
                .format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
    }


    /**
     * 获取两个日期间隔的所有日期
     *
     * @param start 格式 yyyy-MM-dd
     * @param end   格式必须为 yyyy-MM-dd
     * @return List<String> 格式 yyyy-MM-dd
     */
    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> list.add(f.toString()));
        return list;
    }


}
