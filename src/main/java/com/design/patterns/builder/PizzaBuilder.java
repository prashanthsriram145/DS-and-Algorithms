package com.design.patterns.builder;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public Pizza createNewPizzaProduct() {
        pizza = new Pizza();
        return pizza;
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}
