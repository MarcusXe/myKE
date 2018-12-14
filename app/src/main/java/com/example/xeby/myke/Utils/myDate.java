package com.example.xeby.myke.Utils;

import java.util.Calendar;

public class myDate {
    public static Calendar cCal = Calendar.getInstance();
    public static Calendar fistCal = Calendar.getInstance();


    public static void initCal(Calendar c){
        cCal.setFirstDayOfWeek(Calendar.MONDAY);
        fistCal.setFirstDayOfWeek(Calendar.MONDAY);
        setToFirstDayOfThisWeek(c);
    }
    public static void initCal(){
        cCal.setFirstDayOfWeek(Calendar.MONDAY);
        fistCal.setFirstDayOfWeek(Calendar.MONDAY);
        fistCal.set(2018,8,1);
//        cCal.set(2018,11-1,28);

        setToFirstDayOfThisWeek(fistCal);
    }
    public static Calendar setToFirstDayOfThisWeek(Calendar c) {

        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        return c;
    }
public static int getTodayOfWeek(){
        return cCal.get(Calendar.DAY_OF_WEEK);
}
    public static int getWeekSpan() {
        int span=0;
        int cDay=Integer.parseInt(String.valueOf(cCal.getTimeInMillis()/(1000*3600*24)));
        int fDay=Integer.parseInt(String.valueOf(fistCal.getTimeInMillis()/(1000*3600*24)));
        if (cCal.after(fistCal)) {
                span=(cDay-fDay)/7;

    }
       return span;
}
}
