package com.dsalgo;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LongestSubSequence {
    public static void main(String[] args) {
        int a[] = {10, 20, 21, 22, 23};
        System.out.println(findLongestConseqSubseq(a, a.length));
    }

    static int findLongestConseqSubseq(int arr[], int N)
    {
        // add your code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++) {
            map.put(arr[i],arr[i]);
        }
        Set<Integer> countSet = new TreeSet<>();
        NavigableSet<Integer> set = map.navigableKeySet();
        Integer[] array = set.toArray(new Integer[set.size()]);
        int prev = array[0];
        int curr = array[0];
        int count = 1;

        for(int i=1;i<array.length;i++) {
            curr = array[i];

            if(curr == prev + 1) {
                count++;
            } else {
                countSet.add(count);
                count = 1;
            }
            prev = curr;
        }
        countSet.add(count);
        return  countSet != null  && !countSet.isEmpty() ? (int) countSet.toArray()[countSet.size() - 1] : 0;
    }
}
