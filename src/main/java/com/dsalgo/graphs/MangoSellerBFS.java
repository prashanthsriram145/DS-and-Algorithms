package com.dsalgo.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MangoSellerBFS {
    public static void main(String[] args) {
        MangoSellerBFS mangoSellerBFS = new MangoSellerBFS();
        Map<String, String[]>  graph = new HashMap<>();
        graph.put("Prashanth", new String[]{"Hemanth", "Ramesh", "Suresh"});
        graph.put("Hemanth", new String[]{"Raina", "Saina", "Suresh"});
        graph.put("Ramesh", new String[]{"Sunny", "Bunny", "Suresh"});
        graph.put("Suresh", new String[]{"Ravi", "Raghu"});
        graph.put("Raina", new String[]{});
        graph.put("Saina", new String[]{});
        graph.put("Sunny", new String[]{});
        graph.put("Bunny", new String[]{});
        graph.put("Ravi", new String[]{});
        graph.put("Raghu", new String[]{});

        System.out.println(mangoSellerBFS.search(graph, "Prashanth"));
    }

    private String search(Map<String, String[]> graph, String name) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add(name);
        queue.addAll(Arrays.asList(graph.get(name)));
        List<String> checkedList = new ArrayList<>();
        while(!queue.isEmpty()) {
            String nameToBeChecked = queue.pop();
            if(!checkedList.contains(nameToBeChecked)) {
                if(nameToBeChecked.endsWith("i")) {
                    return nameToBeChecked;
                } else {
                    queue.addAll(Arrays.asList(graph.get(nameToBeChecked)));
                }
            }
        }
        return null;
    }
}
