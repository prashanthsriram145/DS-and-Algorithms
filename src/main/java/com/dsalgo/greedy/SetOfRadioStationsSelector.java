package com.dsalgo.greedy;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SetOfRadioStationsSelector {
    public static void main(String[] args) {
        SetOfRadioStationsSelector setOfRadioStationsSelector = new SetOfRadioStationsSelector();
        Set<String> setOfStates = Sets.newHashSet("ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq");
        Map<String, Set<String>> radioStationStatesMap = new TreeMap<>();
        radioStationStatesMap.put("Radio1", Sets.newHashSet("ab", "ac", "ad", "ae", "af", "ag"));
        radioStationStatesMap.put("Radio2", Sets.newHashSet("ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am"));
        radioStationStatesMap.put("Radio3", Sets.newHashSet("ak", "al", "am", "an", "ao", "ap", "aq"));
        radioStationStatesMap.put("Radio4", Sets.newHashSet("aj", "ak", "al", "am", "an"));


        List<String> requiredRadioStations = setOfRadioStationsSelector.identifyAppoximateSetOfRadioStations(setOfStates, radioStationStatesMap);
        requiredRadioStations.forEach(System.out::println);
    }

    private List<String> identifyAppoximateSetOfRadioStations(Set<String> setOfStates, Map<String, Set<String>> radioStationStatesMap) {
        List<String> radioStations = new ArrayList<>();
        String bestStation = null;
        while(!setOfStates.isEmpty()) {
            Set<String> statesCoveredByBestStation = new HashSet<>();
            for(String radioStation : radioStationStatesMap.keySet()) {
                Set<String> statesRequired = new HashSet<>(setOfStates);
                Set<String> statesCoveredByStation = radioStationStatesMap.get(radioStation);
                statesRequired.retainAll(statesCoveredByStation);
                if(statesRequired.size() > statesCoveredByBestStation.size()) {
                    bestStation = radioStation;
                    statesCoveredByBestStation = new HashSet<>(statesCoveredByStation);
                }
            }
            radioStations.add(bestStation);
            setOfStates.removeAll(statesCoveredByBestStation);
        }

        return radioStations;
    }
}
