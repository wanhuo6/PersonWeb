package com.ahuo.bean;

/**
 * Created by ahuo on 17-5-22.
 */
public class test {

    private static int timeSpace = 45; //单位分钟

    public static void main(String[] args) {

        for (int i = 9 * 60; i < 24 * 60; i += timeSpace) {

            int a = i;
            int b = i + timeSpace;
            System.out.println("a=="+getTime(a)+"----b=="+getTime(b));

        }
    }

    private static String getTime(int time) {
        if (time == 0) {
            return "0:00";
        }
        if (time/60>23){
            return "23:59";
        }
        String hour = String.valueOf(time / 60);
        String minute;
        if (time % 60 == 0) {
            minute = "00";
        } else {
            minute = String.valueOf(time % 60);
        }
        return String.valueOf(hour +":"+minute);
    }

}
