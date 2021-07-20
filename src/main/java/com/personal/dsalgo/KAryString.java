package com.personal.dsalgo;

import java.util.Arrays;

public class KAryString {

    private Integer[] a;

    public KAryString(int i) {
        a = new Integer[i];
    }

    public void kString(int n, int k) {

        if (n < 1) {
            System.out.println(Arrays.toString(a));
        }
        else {
            for(int j = 0; j < k; j++) {
                a[n-1] = j;
                kString(n - 1, k);
            }
        }
    }

    public static void main(String[] args) {
        KAryString kAryString = new KAryString(3);
        long start = System.currentTimeMillis();
        kAryString.kString(3, 2);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(start + ", " + end);
    }
}
