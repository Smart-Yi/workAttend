package com.program.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 匡小菜 on 2017/6/29.
 */
public class DateUtils {
    private static Calendar calendar = Calendar.getInstance();
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/29 9:54
     * @params:  * @param
     * @Description:获得当前星期数
     */
    public static int getTodayWeek(Date today) throws ParseException {

//
//        SimpleDateFormat format= new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
//
//        Date date = format.parse("2017-06-25 12:12:12");

        calendar.setTime(today);

        int week  =  calendar.get(calendar.DAY_OF_WEEK) - 1 ;

        if (week < 0 ) week = 7 ;

        return week ;
    }



    /**
     * @Author: Smart-YI
     * @Date: 2017/6/29 10:01
     * @params:  * @param startDate
     * @param endDate
     * @Description:获得分钟时间差
     */
    public static int getMinutes(Date startDate , Date endDate ){

        Long start = startDate.getTime() ;

        Long end   = endDate.getTime()   ;

        int minutes  =  (int)(end - start)/(60 * 1000) ;

        return minutes ;

    }
    /**
     * @Author: Smart-YI
     * @Date: 2017/6/29 10:57
     * @params:  * @param hour
     * @param minute
     * @Description:获取当天的某个时间点
     */
    public static Date getDate(int hour , int minute){

        calendar.set(calendar.HOUR_OF_DAY,hour);

        calendar.set(calendar.MINUTE,minute);

       return calendar.getTime() ;
    }
}

