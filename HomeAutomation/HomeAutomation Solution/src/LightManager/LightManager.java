package LightManager;

import CoreFramework.Observer;
import CoreFramework.HomeEnvironment;

public class LightManager implements Observer {
    private int ambientLightLevel = 0;
    private boolean roomOccupied = false;
    private String currentScene = "default";

    public LightManager() {
        HomeEnvironment.getInstance().registerObserver("ambientLight", this);
        HomeEnvironment.getInstance().registerObserver("roomOccupancy", this);
        HomeEnvironment.getInstance().registerObserver("lightScene", this);
    }

    @Override
    public void update(String eventType, Object value) {
        switch (eventType) {
            case "ambientLight":
                if (value instanceof Integer) {
                    setAmbientLightLevel((Integer) value);
                }
                break;
            case "roomOccupancy":
                if (value instanceof Boolean) {
                    setRoomOccupied((Boolean) value);
                }
                break;
            case "lightScene":
                if (value instanceof String) {
                    setScene((String) value);
                }
                break;
        }
        adjustLighting();
    }

    public void setAmbientLightLevel(int level) {
        this.ambientLightLevel = level;
    }

    public void setRoomOccupied(boolean occupied) {
        this.roomOccupied = occupied;
    }

    public void setScene(String scene) {
        this.currentScene = scene;
    }

    public void adjustLighting() {
        if (!roomOccupied) {
            System.out.println("Lights off - room unoccupied");
            return;
        }

        int brightness;
        switch (currentScene) {
            case "reading":
                brightness = Math.max(70, 100 - ambientLightLevel);
                break;
            case "movie":
                brightness = 30;
                break;
            default:
                brightness = Math.max(50, 100 - ambientLightLevel);
        }

        System.out.println("Adjusting lights to " + brightness + "% brightness for " + currentScene + " scene");
    }

    // Getters
    public int getAmbientLightLevel() { return ambientLightLevel; }
    public boolean isRoomOccupied() { return roomOccupied; }
    public String getCurrentScene() { return currentScene; }
}
