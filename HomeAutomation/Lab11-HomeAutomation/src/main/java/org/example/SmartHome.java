package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SmartHome {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.println("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
        System.out.println("Starting Smart Home System...");

        // Create the core system
        HomeSystem homeSystem = new HomeSystem();

        // Initialize components
        MotionDetectionSystem motionSystem = new MotionDetectionSystem(homeSystem);
        LightManagementSystem lightSystem = new LightManagementSystem(homeSystem);
        TemperatureControlSystem tempSystem = new TemperatureControlSystem(homeSystem);
        EnergyConsumptionSystem energySystem = new EnergyConsumptionSystem(homeSystem);
        VoiceCommandSystem voiceSystem = new VoiceCommandSystem(homeSystem);
        RemoteAccessSystem remoteSystem = new RemoteAccessSystem(homeSystem);

        System.out.println("\n=== All components initialized ===\n");

        // Simulate some events
        simulateEvents(homeSystem, voiceSystem, remoteSystem);
    }

    private static void simulateEvents(HomeSystem homeSystem,
                                       VoiceCommandSystem voiceSystem,
                                       RemoteAccessSystem remoteSystem) {
        try {
            // Initialize some state
            homeSystem.updateState("temperature", 18.0);
            homeSystem.updateState("ambientLight", 70);
            homeSystem.updateState("currentRoom", "livingRoom");

            // Show initial state
            remoteSystem.displayHomeState();

            // Simulate motion detection
            System.out.println("\n=== Simulating motion detection ===");
            homeSystem.updateState("motion", true);
            Thread.sleep(1000);

            // Simulate temperature change
            System.out.println("\n=== Simulating temperature change ===");
            homeSystem.updateState("temperature", 16.0);
            Thread.sleep(1000);

            // Simulate voice commands
            System.out.println("\n=== Simulating voice commands ===");
            voiceSystem.processCommand("turn on lights in the living room");
            Thread.sleep(1000);

            voiceSystem.processCommand("set temperature to 22");
            Thread.sleep(1000);

            voiceSystem.processCommand("change to reading scene");
            Thread.sleep(1000);

            // Simulate remote control
            System.out.println("\n=== Simulating remote control ===");
            remoteSystem.controlDevice("kitchen", true);
            Thread.sleep(1000);

            // Display energy usage
            Map<String, Boolean> deviceStatus = new HashMap<>();
            deviceStatus.put("lighting", true);
            deviceStatus.put("hvac", true);
            deviceStatus.put("kitchen", true);
            homeSystem.updateState("devicePower", deviceStatus);

            // Final state
            System.out.println("\n=== Final system state ===");
            remoteSystem.displayHomeState();

            // Display notifications
            System.out.println("\n=== System Notifications ===");
            List<String> notifications = remoteSystem.getNotifications();
            for (String notification : notifications) {
                System.out.println("- " + notification);
            }

        } catch (InterruptedException e) {
            System.out.println("Simulation interrupted");
        }
    }
}