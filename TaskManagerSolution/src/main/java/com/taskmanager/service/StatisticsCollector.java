package com.taskmanager.service;

import java.util.HashMap;
import java.util.Map;

public class StatisticsCollector {
    private Map<String, Integer> commandCounts = new HashMap<>();

    public void incrementCommandCount(String type) {
        commandCounts.put(type, commandCounts.getOrDefault(type, 0) + 1);
    }

    public Map<String, Integer> getCommandCounts() {
        return new HashMap<>(commandCounts );
    }
}