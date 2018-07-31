/**
 * @author eamiear
 * @date 2018/7/31 10:04
 */

package com.ura.common.utils;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final Logger logger = Logger.getLogger(DateUtils.class);

    public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_TIME_PATERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_TIME_STAMP_PATTERN = "yyyyMMddHHmmssSSS";

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }
        return null;
    }

    public static String format(Date date) {
        return format(date, DATE_TIME_PATERN);
    }

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATERN);
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
