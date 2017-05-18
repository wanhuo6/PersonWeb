package com.ahuo.socket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ahuo on 17-5-16.
 */
public class test {
    public static void main(String[] args) {
        System.out.println("=="+System.currentTimeMillis());

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long now =  1494925616347l;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        System.out.println(now + " = " + formatter.format(calendar.getTime()));

    }
}
