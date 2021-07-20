package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Dijkstraalgo {
    public static void main(String[] args) {
        Dijkstraalgo dijkstraalgo = new Dijkstraalgo();
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> startMap = new HashMap<>();
        startMap.put("A", 6);
        startMap.put("B", 2);
        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("finish", 1);
        Map<String, Integer> bMap = new HashMap<>();
        bMap.put("finish", 5);
        bMap.put("A", 3);
        graph.put("start", startMap);
        graph.put("A", aMap);
        graph.put("B", bMap);

        Map<String, Integer> costs = new HashMap<>();
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("finish", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("A", "start");
        parents.put("B", "start");

        dijkstraalgo.search(graph, "start", "finish", costs, parents);
        System.out.println("Shortest path to finish costs : " + costs.get("finish"));
        System.out.print("Shortest path from start to finish is ");
        Stack<String> stack = new Stack<>();
        String node = "finish";
        while (parents.get(node) != null) {
            stack.push(node);
            node = parents.get(node);
        }
        System.out.print("start ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void search(Map<String, Map<String, Integer>> graph, String start, String finish, Map<String, Integer> costs, Map<String, String> parents) {
        Set<String> processed = new HashSet<>();

        String begin = start;
        while(graph.get(begin) != null && !processed.contains(begin)) {
            processed.add(start);
            Map<String, Integer> targetMap = graph.get(start);
            ArrayList<Map.Entry<String, Integer>> mapAsList = new ArrayList<>(targetMap.entrySet());
            Collections.sort(mapAsList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            for (Map.Entry<String, Integer> entry : mapAsList) {
                Map<String, Integer> innerMap = graph.get(entry.getKey());
                for (String key : innerMap.keySet()) {
                    Integer newCost = costs.get(entry.getKey()) + innerMap.get(key);
                    if (newCost < costs.get(key)) {
                        costs.put(key, newCost);
                        parents.put(key, entry.getKey());
                    }
                    processed.add(key);
                }
                processed.add(entry.getKey());

            }
            begin = mapAsList.get(mapAsList.size() - 1).getKey();
        }
    }
}
