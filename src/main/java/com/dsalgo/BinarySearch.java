package com.dsalgo;

public class BinarySearch {
    public static int LOOPS = 0;
    public static void main(String[] args) {
        int [] arr = {1,4,5,8,10,14,20, 30,50,60,70,80};
        BinarySearch binarySearch = new BinarySearch();
        int elementPosition = binarySearch.search(arr, 0, arr.length - 1, 50);
        System.out.println(elementPosition);
        System.out.println(LOOPS);
    }

    private int search(int[] arr, int low, int high, int element) {
        if (low <= high) {
            LOOPS++;
            int mid = (low + high) / 2;

            if (element == arr[mid]) {
                return mid;
            } else if (element < arr[mid]) {
                high = mid - 1;
                return search(arr, low, high, element);
            } else {
                low = mid + 1;
                return search(arr, low, high, element);
            }
        }
        return -1;
    }
}
