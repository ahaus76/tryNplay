package com.example.demo.greet;

public class LegacyPerson implements Greetable {


    private String legacyName;
    private String legacyLastName;
    private String legacyTitle;

    public LegacyPerson(String legacyName, String legacyLastName, String legacyTitle) {
        this.legacyName = legacyName;
        this.legacyLastName = legacyLastName;
        this.legacyTitle = legacyTitle;
    }

    public String getLegacyName() {
        return legacyName;
    }

    public String getLegacyLastName() {
        return legacyLastName;
    }

    public String getLegacyTitle() {
        return legacyTitle;
    }

    @Override
    public String getName() {
        return getLegacyName();
    }

    @Override
    public String getLastName() {
        return getLegacyLastName();
    }

    @Override
    public String getTitle() {
        return getLegacyTitle();
    }


}
