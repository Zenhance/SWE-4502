package lab11_210042164.implementation.features;


import lab11_210042164.implementation.interfaces.Component;
import lab11_210042164.implementation.manager.StateManager;
import java.util.HashMap;
import java.util.Map;

public class LightManager implements Component {
    private StateManager stateManager;
    private Map<String, Integer> roomLightLevels = new HashMap<>();
    private Map<String, Boolean> roomOccupancy = new HashMap<>();
    private Map<String, Map<String, Integer>> lightScenes = new HashMap<>();
    private int ambientLightLevel = 50; // Default level

    public LightManager(StateManager stateManager) {
        this.stateManager = stateManager;

        // Initialize some scenes
        Map<String, Integer> readingScene = new HashMap<>();
        readingScene.put("LivingRoom", 80);
        readingScene.put("Bedroom", 70);

        Map<String, Integer> movieScene = new HashMap<>();
        movieScene.put("LivingRoom", 20);
        movieScene.put("Bedroom", 10);

        lightScenes.put("reading", readingScene);
        lightScenes.put("movie", movieScene);
    }

    @Override
    public void onStateChange(String key, Object value) {
        switch (key) {
            case "ambientLight":
                updateAmbientLightLevel((Integer) value);
                break;
            case "roomOccupancy":
                updateRoomOccupancy((String) value);
                break;
            case "lightScene":
                activateLightScene((String) value);
                break;
        }
    }

    private void updateAmbientLightLevel(int level) {
        this.ambientLightLevel = level;
        System.out.println("Ambient light level updated to: " + level);
        adjustLightsBasedOnAmbient();
    }

    private void updateRoomOccupancy(String room) {
        // Mark room as occupied
        roomOccupancy.put(room, true);

        // Mark other rooms as unoccupied (simplified approach)
        for (String existingRoom : roomOccupancy.keySet()) {
            if (!existingRoom.equals(room)) {
                roomOccupancy.put(existingRoom, false);
            }
        }

        System.out.println("Room occupancy updated: " + room + " is occupied");
        adjustLightsBasedOnOccupancy();
    }

    private void adjustLightsBasedOnAmbient() {
        // If ambient light is low, increase all room light levels
        for (String room : roomOccupancy.keySet()) {
            if (roomOccupancy.get(room)) { // If room is occupied
                int newLevel = calculateLightLevel(room);
                setRoomLightLevel(room, newLevel);
            }
        }
    }

    private void adjustLightsBasedOnOccupancy() {
        for (String room : roomOccupancy.keySet()) {
            if (roomOccupancy.get(room)) { // If room is occupied
                int newLevel = calculateLightLevel(room);
                setRoomLightLevel(room, newLevel);
            } else {
                setRoomLightLevel(room, 0); // Turn off lights in unoccupied rooms
            }
        }
    }

    private int calculateLightLevel(String room) {
        // Inverse relationship - lower ambient light = higher room light
        return Math.min(100, Math.max(0, 100 - ambientLightLevel));
    }

    private void activateLightScene(String scene) {
        if (lightScenes.containsKey(scene)) {
            System.out.println("Activating " + scene + " scene");
            Map<String, Integer> sceneLevels = lightScenes.get(scene);

            for (String room : sceneLevels.keySet()) {
                if (roomOccupancy.getOrDefault(room, false)) { // Only adjust if room is occupied
                    setRoomLightLevel(room, sceneLevels.get(room));
                }
            }
        }
    }

    private void setRoomLightLevel(String room, int level) {
        roomLightLevels.put(room, level);
        System.out.println("Set " + room + " light level to " + level);
        stateManager.updateState("lightLevel_" + room, level);
    }

    public int getRoomLightLevel(String room) {
        return roomLightLevels.getOrDefault(room, 0);
    }

    public boolean isRoomOccupied(String room) {
        return roomOccupancy.getOrDefault(room, false);
    }

    public int getAmbientLightLevel() {
        return ambientLightLevel;
    }

    public void addLightScene(String sceneName, Map<String, Integer> sceneLevels) {
        lightScenes.put(sceneName, new HashMap<>(sceneLevels));
    }
}