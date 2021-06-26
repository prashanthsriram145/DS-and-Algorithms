package com.stack;

import java.util.Stack;

public class ReverseStackElements {

    public void reverseStackElements(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        Integer popped = s.pop();
        reverseStackElements(s);
        insertAtBottomOfStack(s, popped);
    }

    private void insertAtBottomOfStack(Stack<Integer> s, Integer popped) {
        if (s.isEmpty()) {
            s.push(popped);
            return;
        }
        Integer temp = s.pop();
        insertAtBottomOfStack(s, popped);
        s.push(temp);
    }

    public static void main(String[] args) {
        ReverseStackElements reverseStackElements = new ReverseStackElements();
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.forEach(System.out::print);
        reverseStackElements.reverseStackElements(stack);
        System.out.println(stack.peek());
        stack.forEach(System.out::print);
    }
}
