package com.dsalgo.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new String[]{"B", "C"}));
        graph.put("B", Arrays.asList(new String[]{"D"}));
        graph.put("C", Arrays.asList(new String[]{"A"}));
        graph.put("D", Arrays.asList(new String[]{"T"}));

        Map<String, Integer> distances = new HashMap<>();
        distances.put("A", 0);
        distances.put("B", Integer.MAX_VALUE);
        distances.put("C", Integer.MAX_VALUE);
        distances.put("D", Integer.MAX_VALUE);
        distances.put("T", Integer.MAX_VALUE);

        Map<String, String> predecessor = new HashMap<>();
        predecessor.put("A", "-1");

        boolean found = breadthFirstSearch.search(graph, distances, predecessor, "A", "T", 5);

        if (found) {
            printSearchPath(distances, predecessor, "T");
        }

    }

    private static void printSearchPath(final Map<String, Integer> distances, final Map<String, String> predecessor, final String destination) {
        Stack<String> path = new Stack<>();
        path.push(destination);
        String element = destination;
        while(!predecessor.get(element).equalsIgnoreCase("-1")) {
            element = predecessor.get(element);
            path.push(element);
        }
        System.out.println("Here is the path with length " + distances.get(destination));
        while(!path.isEmpty()) {
            System.out.print(path.pop());
        }
    }

    private boolean search(Map<String, List<String>> graph, Map<String, Integer> distances, Map<String, String> predecessor, String source, String destination, int i) {
        Queue<String> queue = new ArrayDeque();
        queue.add(source);

        Set<String> processed = new HashSet<>();

        while(!queue.isEmpty()) {
            String element = queue.remove();
            processed.add(element);
            if (element.equalsIgnoreCase(destination)) {
                return true;
            }
            List<String> targets = graph.get(element);
            queue.addAll(targets);

            for(String target : targets) {
                int newDistance = distances.get(element) + 1;
                if (newDistance < distances.get(target)) {
                    distances.put(target, newDistance);
                    predecessor.put(target, element);
                }
                if (target.equalsIgnoreCase(destination)) {
                    return true;
                }
            }
        }
        return false;
    }


}


