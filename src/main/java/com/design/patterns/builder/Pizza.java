package com.design.patterns.builder;

import lombok.Data;

@Data
public class Pizza {

    private String dough;
    private String sauce;
    private String topping;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(dough).append(":").append(sauce).append(":").append(topping).toString();
    }

}
