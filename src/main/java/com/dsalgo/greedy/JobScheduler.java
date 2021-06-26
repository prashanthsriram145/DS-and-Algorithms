package com.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobScheduler {
    public static void main(String[] args) {

        Integer s[] = {1,2,3,5,8,5};
        Integer f[] = {2,6,4,7,9,9};
        int n = s.length;
        List<Map.Entry<Integer, Integer>> lst = sortAscending(f);
        List<Integer> indicesList = new ArrayList<>();
        List<Integer> finishTimesList = new ArrayList<>();
        List<Integer> startTimesList = new ArrayList<>();
        Integer[] finalS = s;
        lst.stream().forEach(entry -> {
            indicesList.add(entry.getKey());
            finishTimesList.add(entry.getValue());
            startTimesList.add(finalS[entry.getKey()]);
        });
        s = startTimesList.toArray(s);
        f = finishTimesList.toArray(f);

        List<Integer> lst1 = schedule(n, s, f);
        System.out.println(lst1);

    }

    private static List<Map.Entry<Integer, Integer>> sortAscending(Integer[] f) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<f.length;i++) {
            map.put(i,f[i]);
        }
        List<Map.Entry<Integer,Integer>> lst = new ArrayList<>(map.entrySet());
        Collections.sort(lst, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        });
        return lst;
    }

    private static List<Integer> schedule(Integer n, Integer[] s, Integer[] f) {
        int i = 0;
        List<Integer> lst = new ArrayList<>();
        lst.add(i);
        for (int j=1;j<n;j++) {
            if(f[i] <= s[j]) {
                lst.add(j);
                i = j;
            }
        }
        return lst;
    }
}
