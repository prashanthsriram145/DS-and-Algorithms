package com.dsalgo;

public class WaterBwBuildingsNew {
    public static void main(String[] args) {
        WaterBwBuildingsNew waterBwBuildingsNew = new WaterBwBuildingsNew();
        int [] data = {3,0,0,2,0,4};
        System.out.println(waterBwBuildingsNew.find(data));
    }

    private int find(int[] data) {
        int count = 0;
        for(int i=1;i<data.length-1;i++) {
            int leftMax = findMax(0, i, data);
            int rightMax = findMax(i+1, data.length, data);
            int min = Math.min(leftMax, rightMax);
            count = count + (min-data[i]);
        }
        return count;
    }

    private int findMax(int start, int end, int [] data) {
        int max = data[start];
        for(int i=start+1; i<end; i++) {
            if(data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
