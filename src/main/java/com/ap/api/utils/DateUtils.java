package com.ap.api.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private final static String ddmmyyhhmmss = "dd-MM-yyyy HH:mm:ss";

    public static Date getGMTDate() {
        Calendar aNotGMTCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-2"));
        aNotGMTCalendar.getTime();
        return aNotGMTCalendar.getTime();

    }

    public static Date getSysDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getDateByPattern(String pattern, Date date) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String getCurrentDateTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

    public static String getFormatedCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ddmmyyhhmmss);
        return dateFormat.format(new Date());

    }

    public static Date atStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    public static Date atEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }


    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static String getStrSysDate(String str_date_format) {
        // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat(str_date_format);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String getDateStr(Date p_obj_date, String p_str_date_format) {
        SimpleDateFormat formatter = new SimpleDateFormat(p_str_date_format);
        return formatter.format(p_obj_date);
    }
    public static java.sql.Date getUtilDateToSQLdate(Date obj_util_date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(obj_util_date);
        return new java.sql.Date(cal.getTime().getTime());
    }

    /*
        return HH:mm
     */
    public static Date getCurrentSysTime() throws ParseException {
        String str_default_time_format = "HH:mm";
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formatter = new SimpleDateFormat(str_default_time_format);
        String utildate = formatter.format(date.getTime());
        Date dater = formatter.parse(utildate);
        return (Date) dater;
    }

    /*
        get minitues from two date
     */
    public static String twodateDiffinminutes(Date fromDate, Date toDate) {

        Long duration = fromDate.getTime() - toDate.getTime();
        Long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        return diffInMinutes.toString();
    }
    /*
        convert string date with specific format 
     */
    public static Date stringtodate(String date, String pattern) throws Exception {
        SimpleDateFormat dates = new SimpleDateFormat(pattern);
        if (date != null && !date.trim().equals("")) {
            Date currTodate = dates.parse(date);
            return currTodate;
        } else {
            return null;
        }
    }
}
