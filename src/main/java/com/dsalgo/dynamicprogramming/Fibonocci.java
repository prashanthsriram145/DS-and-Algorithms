package com.dsalgo.dynamicprogramming;

public class Fibonocci {
    public static void main(String[] args) {
        Fibonocci fibonocci = new Fibonocci();
        long start = System.currentTimeMillis();
        System.out.println("Starting calculation..");
        System.out.println(fibonocci.dynamicaProgramming(100));
        long end = System.currentTimeMillis();
        System.out.println(" Time taken : " + (end-start));
    }

    private int naiveRecursive(long n) {
        if (n==0) return 1;
        if (n==1) return 1;
        return naiveRecursive(n-1) + naiveRecursive(n-2);
    }
    // 1 1 2 3 5 8
    private long dynamicaProgramming(long n) {
        long fib0 = 1;
        long fib1 = 1;
        int index = 1;
        long fib = 0;
        while (index < n) {
            fib = fib0 + fib1;
            fib0 = fib1;
            fib1 = fib;
            index++;
        }
        return fib;
    }
}
