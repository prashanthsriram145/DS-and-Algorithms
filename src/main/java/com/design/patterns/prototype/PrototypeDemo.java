package com.design.patterns.prototype;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrototypeDemo {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Person person = personFactory.getPerson("official");
        log.info(person.toString());
        person = personFactory.getPerson("private");
        log.info(person.toString());
    }
}
