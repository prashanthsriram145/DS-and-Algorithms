package com.dsalgo.dynamicprogramming;

public class FibonacciNew {
    public static void main(String[] args) {
        FibonacciNew fibonacciNew = new FibonacciNew();
        fibonacciNew.print(100);
    }

    private void print(int n) {
        int [] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        System.out.print(fib[0] + " " + fib[1]);
        for(int i=2; i<n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            System.out.print(" " + fib[i]);
        }
    }
}
