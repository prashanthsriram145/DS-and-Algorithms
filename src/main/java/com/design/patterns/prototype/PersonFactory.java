package com.design.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class PersonFactory {

    private static Map<String, Person> personMap = new HashMap<>();
    static {
        personMap.put("official", new Official());
        personMap.put("private", new Private());
        personMap.put("homemaker", new HomeMaker());
    }

    public Person getPerson(String type) {
        return personMap.get(type).clone();
    }
}
