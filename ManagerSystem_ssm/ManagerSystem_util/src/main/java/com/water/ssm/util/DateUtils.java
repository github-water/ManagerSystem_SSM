package com.water.ssm.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期与字符串转换工具包
 */
public class DateUtils {

    /**
     * 日期转化为字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(date);
        return dateString;
    }

    public static Date stringToDate(String string, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(string);
        return date;


    }
}
