package com.example.demo.greet;

public class Person implements Greetable {

    private String name;
    private String lastName;
    private String title;

    public Person(String name, String lastName, String title) {
        this.name = name;
        this.lastName = lastName;
        this.title = title;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
