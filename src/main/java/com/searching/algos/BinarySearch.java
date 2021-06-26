package com.searching.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public Integer binSearch(List<Integer> elements, Integer element, Integer start, Integer end) {
        int mid = (end+start)/2;
        if (mid < elements.size()) {
            if (elements.get(mid) == element) {
                return mid;
            }
            if (element < elements.get(mid)) {
                return binSearch(elements, element, start, mid);
            } else if (element > elements.get(mid)) {
                return binSearch(elements, element, mid+1, elements.size());
            }

        } else {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> elements = Arrays.asList(1,2,3,4,5,6);
        System.out.println("position of element: "+binarySearch.binSearch(elements, 6, 0, elements.size()));
    }
}
