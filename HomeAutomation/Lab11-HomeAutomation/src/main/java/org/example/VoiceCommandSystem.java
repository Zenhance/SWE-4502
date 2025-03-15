package org.example;

import java.util.*;

public class VoiceCommandSystem {
    private HomeSystem homeSystem;
    private List<String> commandHistory = new ArrayList<>();

    public VoiceCommandSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
    }

    public void processCommand(String command) {
        command = command.toLowerCase().trim();
        commandHistory.add(command);

        System.out.println("Processing voice command: " + command);

        // Simple command parsing
        if (command.contains("turn on") || command.contains("switch on")) {
            if (command.contains("lights")) {
                String room = extractRoom(command);
                homeSystem.updateState("currentRoom", room);
                Map<String, Boolean> deviceStatus = getOrCreateDeviceStatusMap();
                deviceStatus.put("lighting", true);
                homeSystem.updateState("devicePower", deviceStatus);
                System.out.println("Lights turned on in " + room);
            }
            else if (command.contains("heat") || command.contains("heating")) {
                homeSystem.updateState("targetTemperature", 23.0);
                System.out.println("Heating system activated with target temperature 23°C");
            }
        }
        else if (command.contains("turn off") || command.contains("switch off")) {
            if (command.contains("lights")) {
                String room = extractRoom(command);
                homeSystem.updateState("currentRoom", room);
                Map<String, Boolean> deviceStatus = getOrCreateDeviceStatusMap();
                deviceStatus.put("lighting", false);
                homeSystem.updateState("devicePower", deviceStatus);
                System.out.println("Lights turned off in " + room);
            }
            else if (command.contains("heat") || command.contains("heating")) {
                homeSystem.updateState("targetTemperature", 18.0);
                System.out.println("Heating system lowered with target temperature 18°C");
            }
        }
        else if (command.contains("set temperature") || command.contains("change temperature")) {
            // Extract temperature value
            double temperature = extractTemperature(command);
            if (temperature > 0) {
                homeSystem.updateState("targetTemperature", temperature);
            }
        }
        else if (command.contains("scene") || command.contains("mode")) {
            if (command.contains("reading")) {
                homeSystem.updateState("lightScene", "reading");
            }
            else if (command.contains("movie") || command.contains("watching")) {
                homeSystem.updateState("lightScene", "movie");
            }
            else if (command.contains("relax")) {
                homeSystem.updateState("lightScene", "relaxing");
            }
        }
        else {
            System.out.println("Command not recognized");
        }
    }

    private String extractRoom(String command) {
        String room = "livingRoom"; // Default

        if (command.contains("living")) {
            room = "livingRoom";
        }
        else if (command.contains("kitchen")) {
            room = "kitchen";
        }
        else if (command.contains("bedroom")) {
            room = "bedroom";
        }
        else if (command.contains("bathroom")) {
            room = "bathroom";
        }

        return room;
    }

    private double extractTemperature(String command) {
        // Simple regex to find numbers in the command
        String[] words = command.split("\\s+");
        for (String word : words) {
            try {
                return Double.parseDouble(word);
            } catch (NumberFormatException e) {
                // Not a number, continue
            }
        }
        return -1; // No temperature found
    }

    @SuppressWarnings("unchecked")
    private Map<String, Boolean> getOrCreateDeviceStatusMap() {
        Map<String, Boolean> deviceStatus =
                (Map<String, Boolean>) homeSystem.getStateValue("devicePower");

        if (deviceStatus == null) {
            deviceStatus = new HashMap<>();
            homeSystem.updateState("devicePower", deviceStatus);
        }

        return deviceStatus;
    }

    public List<String> getCommandHistory() {
        return new ArrayList<>(commandHistory);
    }
}