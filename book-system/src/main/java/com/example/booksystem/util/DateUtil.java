package com.example.booksystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtil {

    public static long getDateGap(String pre, String now) throws ParseException {
        //指定时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long gapDay = 24 * 60 * 60 * 1000;
        Date nowDate = dateFormat.parse(now);
        Date preDate = dateFormat.parse(pre);
        long gap = (nowDate.getTime() - preDate.getTime()) / gapDay;
        return gap;
    }
}
