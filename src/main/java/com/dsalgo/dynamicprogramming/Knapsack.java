package com.dsalgo.dynamicprogramming;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int [] wt = new int[]{10, 20, 30};
        int [] val = new int[]{60, 100, 120};
        int W = 50;
        int n = val.length;
        System.out.println(knapsack.find(W, wt, val, n));
    }

    private int find(int W, int[] wt, int[] val, int n) {
        int k[][] = new int[n+1][W+1];

        for(int i=0; i<=n; i++) {
            for(int w=0; w<=W;w++) {
                if(i==0 || w==0) {
                    k[i][w] = 0;
                } else if(wt[i-1] <= w) {
                    k[i][w] = Math.max(k[i-1][w], val[i-1] + k[i-1][w-wt[i-1]]);
                } else {
                    k[i][w] = k[i-1][w-1];
                }
            }
        }

        return k[n][W];
    }
}
