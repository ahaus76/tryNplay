package com.example.demo.greet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiGreeter {

    public String createGreetMsg(List<String> names, Date date) {
        StringBuffer msg = new StringBuffer();
        for (String name : names) {
            msg.append(createGreetMsg(name, date));
        }
        return msg.toString();
    }

    private String createGreetMsg(String name, Date date) {
        StringBuffer msg = new StringBuffer();
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        if (cal.get(Calendar.AM_PM) == Calendar.AM) {
            msg.append("Good morning "); // replace with loading text from resource bundle
        } else if (cal.get(Calendar.HOUR_OF_DAY) <= 18) {
            msg.append("Good afternoon "); // replace with loading text from resource bundle
        } else {
            msg.append("Good evening "); // replace with loading text from resource bundle
        }

        msg.append(name);

        return msg.toString();
    }
}
