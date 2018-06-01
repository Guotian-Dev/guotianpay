package com.guotianpay.guotianchain.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * yyyy-MM-dd HH:mm:ss
     * 返回 时间格式如：2018-01-01 00:00:00
     * @return
     */
    public static String getCurrentTime(){

        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return df.format(day);
    }
}
