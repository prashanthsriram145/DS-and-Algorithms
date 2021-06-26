package com.dsalgo;

public class CandiesToChildren {
    public static void main(String[] args) {
        int []grades = {2,3,4,4,3,2,1};
        int count = getMiniumCandies(grades);
        System.out.println(count);
    }

    private static int getMiniumCandies(int[] grades) {
        int [] candies = new int[grades.length];
        candies[0] = 1;
        for(int i=1;i<grades.length;i++) {
            if(grades[i] >= grades[i-1]){
                candies[i] =  candies[i-1] + 1;
            } else if(grades[i] < grades[i-1]) {
                candies[i] = candies[i-1] - 1;
            }
            if(candies[i] <= 0) {
                candies[i] = 0;
            }
        }
        int sum = 0;
        for(int candy : candies) {
            sum = sum + candy;
        }
        return sum;
    }
}
