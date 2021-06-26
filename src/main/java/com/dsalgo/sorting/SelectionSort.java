package com.dsalgo.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {50,40,30,20,10};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void sort(int[] arr) {
        int smallestIndex = 0;
        for(int i=0; i<arr.length-1;i++) {
            smallestIndex = findSmallest(arr, i, arr.length-1);
            swap(arr, i, smallestIndex);
        }
    }

    private void swap(int[] arr, int i, int smallestIndex) {
        int temp = arr[i];
        arr[i] = arr[smallestIndex];
        arr[smallestIndex] = temp;
    }

    private int findSmallest(int[] arr, int start, int end) {
        int smallest = arr[start];
        int smallestIndex = start;
        for(int i=start+1; i<=end;i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
