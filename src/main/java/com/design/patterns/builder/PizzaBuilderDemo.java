package com.design.patterns.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        PizzaBuilder hawainPizzaBuilder = new HawaainPizzaBuilder();
        PizzaBuilder spicePizzaBuilder = new SpicePizzaBuilder();
        Waiter director = new Waiter();
        director.setPizzaBuilder(hawainPizzaBuilder);
        director.constructPizza();
        Pizza pizza = director.getPizza();
        log.info(pizza.toString());
        director.setPizzaBuilder(spicePizzaBuilder);
        director.constructPizza();
        pizza = director.getPizza();
        log.info(pizza.toString());
    }
}
