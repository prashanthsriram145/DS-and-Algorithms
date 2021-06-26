package com.design.patterns.prototype;

public class Private implements Person {
    private String name;
    public Private() {
        name = "Private Name";
    }

    @Override
    public Person clone() {
        return new Private();
    }

    @Override
    public String toString() {
        return name;
    }
}
