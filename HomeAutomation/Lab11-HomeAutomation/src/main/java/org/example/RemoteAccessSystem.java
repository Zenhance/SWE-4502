package org.example;

import java.util.*;

public class RemoteAccessSystem implements StateChangeObserver {
    private HomeSystem homeSystem;
    private List<String> notifications = new ArrayList<>();

    public RemoteAccessSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
        homeSystem.registerObserver("all", this); // Monitor all state changes
    }

    @Override
    public void onStateChange(String property, Object oldValue, Object newValue) {
        System.out.println("Remote App: State changed - " + property + " from " + oldValue + " to " + newValue);

        // Generate notifications for important events
        if (property.equals("motion") && newValue instanceof Boolean && (Boolean)newValue) {
            String location = (String)homeSystem.getStateValue("currentRoom");
            createNotification("Motion detected in " + location);
        }
        else if (property.equals("temperature")) {
            Double temp = (Double)newValue;
            Double target = (Double)homeSystem.getStateValue("targetTemperature");

            if (target != null && Math.abs(temp - target) > 5) {
                createNotification("Temperature significantly different from target: Current=" +
                        temp + "°C, Target=" + target + "°C");
            }
        }
    }

    public void displayHomeState() {
        System.out.println("\n===== HOME SYSTEM STATE =====");
        EnvironmentalState state = homeSystem.getFullState();

        for (Map.Entry<String, Object> entry : state.getAllValues().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("============================\n");
    }

    public void createNotification(String message) {
        notifications.add(message);
        System.out.println("NOTIFICATION: " + message);
    }

    public List<String> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public void clearNotifications() {
        notifications.clear();
        System.out.println("Notifications cleared");
    }

    public void controlDevice(String device, boolean turnOn) {
        Map<String, Boolean> deviceStatus = getOrCreateDeviceStatusMap();
        deviceStatus.put(device, turnOn);
        homeSystem.updateState("devicePower", deviceStatus);

        System.out.println("Remote command: " + device + " turned " + (turnOn ? "on" : "off"));
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
}