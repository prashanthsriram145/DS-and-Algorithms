package com.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ReverseElementsInQueue {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.forEach(System.out::print);
        reverseElements(queue);
        System.out.println();
        int [] arr = {1,2,4};
        System.out.println(arr.length);
        queue.forEach(System.out::print);
    }

    private static void reverseElements(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Integer polledItem = queue.poll();
            stack.push(polledItem);
        }
        while (!stack.isEmpty()) {
            Integer poppedItem = stack.pop();
            queue.add(poppedItem);
        }
    }
}
