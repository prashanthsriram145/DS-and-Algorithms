package com.design.patterns.prototype;

public class Official implements Person {
    private String name;
    public Official() {
        name = "Official Name";
    }

    @Override
    public Person clone() {
        return new Official();
    }

    @Override
    public String toString() {
        return name;
    }
}
