package com.design.patterns.prototype;

public class HomeMaker implements Person {
    private String name;
    public HomeMaker() {
        name = "HomeMaker Name";
    }

    @Override
    public Person clone() {
        return new HomeMaker();
    }

    @Override
    public String toString() {
        return name;
    }
}
