package com.example.demo.greet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SingleGreeter {

    public String createGreetMsg(String name, Date date) {
        String msg;
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        if (cal.get(Calendar.AM_PM) == Calendar.AM) {
            msg = "Good morning ";
        } else if (cal.get(Calendar.HOUR_OF_DAY) <= 18) {
            msg = "Good afternoon ";
        } else {
            msg = "Good evening ";
        }

        msg = msg + name;

        return msg;
    }
}
