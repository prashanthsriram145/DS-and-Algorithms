package com.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobSchedulerNew {
    public static void main(String[] args) {
        JobSchedulerNew jobSchedulerNew = new JobSchedulerNew();
        int [] starts = {1,3,2,5,8,5};
        int [] ends = {2,4,6,7,9,9};
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<starts.length;i++) {
            map.put(starts[i], ends[i]);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        int end = ends[0];
        int jobCount = 1;
        for(int i=1;i<list.size();i++) {
            if(end <= starts[i]) {
                end = ends[i];
                jobCount++;
            }
        }
        System.out.println(jobCount);
    }
}
