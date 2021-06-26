package com.stack;

import java.util.Stack;

public class GetMinimumWithBigO1ForStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {
        mainStack.push(element);
        if (minStack.isEmpty()) {
            minStack.push(element);
        }
        if (element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        minStack.pop();
        return mainStack.pop();
    }

    public Integer getMinimum() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMinimumWithBigO1ForStack getMinimumWithBigO1ForStack = new GetMinimumWithBigO1ForStack();
        getMinimumWithBigO1ForStack.push(2);
        getMinimumWithBigO1ForStack.push(6);
        getMinimumWithBigO1ForStack.push(4);
        getMinimumWithBigO1ForStack.push(1);
        getMinimumWithBigO1ForStack.push(5);
        getMinimumWithBigO1ForStack.push(1);
        System.out.println(getMinimumWithBigO1ForStack.getMinimum());
        getMinimumWithBigO1ForStack.pop();
        getMinimumWithBigO1ForStack.pop();
        System.out.println(getMinimumWithBigO1ForStack.getMinimum());
    }
}
