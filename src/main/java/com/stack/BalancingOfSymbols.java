package com.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancingOfSymbols {

    private static Map<Character, Character> symbolsMap = new HashMap<>();
    static {
        symbolsMap.put('}', '{');
        symbolsMap.put(']', '[');
        symbolsMap.put(')', '(');
    }

    public boolean isBalancingValid(String symbols) {
        Stack<Character> stack = new Stack<>();
        for (char c : symbols.toCharArray()) {
            if (symbolsMap.containsValue(c)) {
                stack.push(c);
            } else if (symbolsMap.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popped = stack.pop();
                if (!popped.equals(symbolsMap.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancingOfSymbols balancingOfSymbols = new BalancingOfSymbols();
        boolean balanced = balancingOfSymbols.isBalancingValid("((A+B)+[C-D]}");
        System.out.println("Balanced : " + balanced);
    }

}
