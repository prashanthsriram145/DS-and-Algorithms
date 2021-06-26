package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class WaterBetweenBuildings {
    public static void main(String[] args) {
        int a[] = {3,0,0,2,0,4};
        List<Integer> lst = calculateWaterBetweenBuildings(a);
        int sum = lst.stream().mapToInt(integer -> integer).sum();
        System.out.println(sum);
    }

    private static List<Integer> calculateWaterBetweenBuildings(int[] a) {
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        for(int i=1;i<a.length-1;i++) {
            int leftMax = findMax(0, i, a);
            int rightMax = findMax(i+1,a.length, a);
            int min = Math.min(leftMax, rightMax);
            lst.add(min-a[i]);
        }
        return lst;
    }

    private static int findMax(int i, int i1, int[] a) {
        int max = a[i];
        for(int x=i;x<i1;x++) {
            if(a[x] > max) {
                max = a[x];
            }
        }
        return max;
    }
}
