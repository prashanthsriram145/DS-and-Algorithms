package com.searching.algos;

import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;

public class JumpSearch {
    public Integer searchAndFindIndex(Integer array[], Integer element) {
        int stepSize = (int) Math.floor(Math.sqrt(array.length));
        int steps = stepSize;
        int prev = 0;
        while (array[Math.min(steps, array.length)-1] < element) {
            prev = steps;
            steps = steps + stepSize;
            if (steps > array.length) {
                return -1;
            }
        }
        while (array[prev] < element) {
            prev++;
            if (prev > array.length) {
                return -1;
            }
        }
        if (array[prev] == element) {
            return prev;
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        Integer a[] = {1,2,3,4,5,6};
        System.out.println("Index of element: " + jumpSearch.searchAndFindIndex(a, 5));
    }
}
