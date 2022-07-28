package com.example.demo.greet;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar();
        int hourOfDay = 19;
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        Date date = calendar.getTime();

        List<String> names = new LinkedList<>();
        names.add("john");
        System.out.println(new MultiGreeter().createGreetMsg(names, date));


        names = new LinkedList<>();
        names.add("john, ");
        names.add("merry, ");
        names.add("fred ");
        System.out.println(new MultiGreeter().createGreetMsg(names, date));


    }
}


