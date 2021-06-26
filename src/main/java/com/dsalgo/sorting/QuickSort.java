package com.dsalgo.sorting;

import java.util.Arrays;

public class QuickSort {
    public static int loopCount = 0;
    public static void main(String[] args) {
        int arr[] = {40,30,50,20,10};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(loopCount);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            loopCount++;
            int partition = partition(arr, low, high);
            sort(arr, low, partition-1);
            sort(arr, partition+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for(int j=low;j<high;j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
