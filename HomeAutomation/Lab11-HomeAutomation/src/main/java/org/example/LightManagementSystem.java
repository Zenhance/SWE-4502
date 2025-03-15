package org.example;

import java.util.*;

public class LightManagementSystem implements StateChangeObserver {
    private HomeSystem homeSystem;
    private Map<String, LightScene> lightScenes = new HashMap<>();
    private Map<String, Integer> roomLightLevels = new HashMap<>();

    public LightManagementSystem(HomeSystem homeSystem) {
        this.homeSystem = homeSystem;
        homeSystem.registerObserver("motion", this);
        homeSystem.registerObserver("ambientLight", this);
        homeSystem.registerObserver("lightScene", this);

        // Initialize some predefined scenes
        lightScenes.put("reading", new LightScene("reading", 80));
        lightScenes.put("movie", new LightScene("movie", 30));
        lightScenes.put("relaxing", new LightScene("relaxing", 50));
    }

    @Override
    public void onStateChange(String property, Object oldValue, Object newValue) {
        if (property.equals("motion") && newValue instanceof Boolean && (Boolean)newValue) {
            String room = (String)homeSystem.getStateValue("currentRoom");
            adjustLightsForOccupancy(room, true);
        }
        else if (property.equals("ambientLight") && newValue instanceof Integer) {
            adjustLightsForAmbientLevel((Integer)newValue);
        }
        else if (property.equals("lightScene") && newValue instanceof String) {
            activateScene((String)newValue);
        }
    }

    public void adjustLightsForOccupancy(String room, boolean occupied) {
        if (occupied) {
            Integer ambientLight = (Integer)homeSystem.getStateValue("ambientLight");
            if (ambientLight != null && ambientLight < 50) {
                int targetLevel = 70;
                roomLightLevels.put(room, targetLevel);
                System.out.println("Lights in " + room + " turned on to " + targetLevel + "% due to occupancy");
            }
        } else {
            roomLightLevels.put(room, 0);
            System.out.println("Lights in " + room + " turned off due to vacancy");
        }
    }

    public void adjustLightsForAmbientLevel(int ambientLightLevel) {
        String room = (String)homeSystem.getStateValue("currentRoom");
        Boolean occupied = (Boolean)homeSystem.getStateValue("motion");

        if (occupied != null && occupied && room != null) {
            int targetLevel = 100 - ambientLightLevel;
            targetLevel = Math.max(0, Math.min(100, targetLevel));
            roomLightLevels.put(room, targetLevel);
            System.out.println("Lights in " + room + " adjusted to " + targetLevel + "% based on ambient light");
        }
    }

    public void activateScene(String sceneName) {
        String room = (String)homeSystem.getStateValue("currentRoom");
        LightScene scene = lightScenes.get(sceneName);

        if (scene != null && room != null) {
            roomLightLevels.put(room, scene.getBrightness());
            System.out.println("Light scene '" + sceneName + "' activated in " + room +
                    " with brightness " + scene.getBrightness() + "%");
        }
    }

    // Inner class for light scenes
    private static class LightScene {
        private String name;
        private int brightness;

        public LightScene(String name, int brightness) {
            this.name = name;
            this.brightness = brightness;
        }

        public String getName() { return name; }
        public int getBrightness() { return brightness; }
    }
}