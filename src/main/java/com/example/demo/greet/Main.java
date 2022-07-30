package com.example.demo.greet;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar();
        // Set hour of thr Day used to calc. morning, afternoon or evening
        int hourOfDay = 8;
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        Date date = calendar.getTime();

        List<Greetable> persons = findPersonsToGreet();

        System.out.println(new MultiGreeter().createGreetMsg(persons, date));


    }

    private static List<Greetable> findPersonsToGreet() {

        List<Greetable> persons = new LinkedList<>();

        persons.add(new Person("John", "House", "Mr."));
        persons.add(new Person("Fred", "Master", "Prof."));
        persons.add(new LegacyPerson("Merry", "Forster", "Mrs."));
        persons.add(new LegacyPerson("Donald", "Biden", "President"));

        return persons;
    }
}


