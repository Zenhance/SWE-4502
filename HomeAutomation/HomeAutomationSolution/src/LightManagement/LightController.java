package LightManagement;

import CoreFramework.*;
import java.util.HashMap;
import java.util.Map;

// LightController reacts to environment state changes
public class LightController implements Observer {
    private boolean isLightOn;
    private LightScene currentScene;
    private int ambientLightLevel;
    private boolean roomOccupied;

    private static final int LIGHT_THRESHOLD = 30; // Below this, lights turn on

    private Map<String, LightScene> scenes = new HashMap<>();

    public LightController() {
        // Define lighting scenes
        scenes.put("Reading", new LightScene("Reading", 80));
        scenes.put("Movie", new LightScene("Movie", 20));
        scenes.put("Relax", new LightScene("Relax", 50));
        this.currentScene = scenes.get("Relax"); // Default scene
    }

    @Override
    public void update(EnvironmentState state) {
        this.ambientLightLevel = state.getLightLevel();
        this.roomOccupied = state.isMotionDetected();
        adjustLighting();
    }

    private void adjustLighting() {
        if (roomOccupied && ambientLightLevel < LIGHT_THRESHOLD) {
            isLightOn = true;
        } else {
            isLightOn = false;
        }
        System.out.println("Light status: " + (isLightOn ? "ON" : "OFF") + ", Scene: " + currentScene.getName());
    }

    public void setScene(String sceneName) {
        if (scenes.containsKey(sceneName)) {
            this.currentScene = scenes.get(sceneName);
        }
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public String getCurrentScene() {
        return currentScene.getName();
    }
}
