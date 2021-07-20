package com.dsalgo;

public class CandiesToChildrenNew {
    public static void main(String[] args) {
        CandiesToChildrenNew candiesToChildrenNew = new CandiesToChildrenNew();
        int [] marks = {23,14,15,14,56,29,14};
        System.out.println(candiesToChildrenNew.find(marks));
    }

    private int find(int[] marks) {
        int [] candiesCount = new int[marks.length];
        for(int i=0;i<marks.length;i++) {
            candiesCount[i] = 1;
        }
        for(int i=1;i<marks.length;i++) {
            if(marks[i] > marks[i-1]) {
                candiesCount[i] = candiesCount[i-1] + 1;
            } else {
                candiesCount[i] = 1;
            }
        }

        for(int i=marks.length-2;i>=0;i--) {
            if(marks[i] > marks[i+1]) {
                candiesCount[i] = Math.max(candiesCount[i], candiesCount[i+1] + 1);
            } else {
                candiesCount[i] = Math.max(candiesCount[i], 1);
            }
        }
        int totalCandies = 0;
        for(int i=0;i<candiesCount.length;i++) {
            totalCandies = totalCandies + candiesCount[i];
        }
        return totalCandies;
    }
}
