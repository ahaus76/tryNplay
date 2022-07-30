package com.example.demo.greet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MultiGreeter {

    public String createGreetMsg(List<Greetable> persons, Date date) {
        StringBuffer msg;
        msg = new StringBuffer();
        for (Greetable person : persons) {
            msg.append(createGreetMsg(person, date));
        }
        return msg.toString();
    }

    public String createGreetMsg(Greetable person, Date date) {
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
        
        msg.append(String.format("%s %s %s \n ", person.getTitle(), person.getName(), person.getLastName()));

        return msg.toString();
    }
}
