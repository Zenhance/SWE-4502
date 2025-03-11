package Code.Controllers;

import Code.Interfaces.Component;
import Code.StateManagementClasses.StateManager;

public class LightManager implements Component {
    private StateManager stateManager;
    private boolean isOccupied = false;
    private String currentScene = "default"; // Default scene

    public LightManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void onStateChange(String key, Object value) {
        switch (key) {
            case "lightLevel":
                adjustLighting((Double) value);
                break;
            case "occupancy":
                adjustLightingBasedOnOccupancy((Boolean) value);
                break;
            case "scene":
                setLightingScene((String) value);
                break;
            default:
                System.out.println("Unknown state change: " + key);
        }
    }

    private void adjustLighting(double lightLevel) {
        if (!isOccupied) {
            System.out.println("Room is empty. Lights off.");
            return;
        }

        if (lightLevel < 20) {
            System.out.println("Low ambient light detected. Increasing brightness.");
        } else {
            System.out.println("Sufficient ambient light. Adjusting accordingly.");
        }
    }

    private void adjustLightingBasedOnOccupancy(boolean occupied) {
        isOccupied = occupied;
        if (isOccupied) {
            System.out.println("Room occupied. Adjusting lighting.");
        } else {
            System.out.println("Room unoccupied. Turning off lights.");
        }
    }

    private void setLightingScene(String scene) {
        this.currentScene = scene;
        switch (scene.toLowerCase()) {
            case "reading":
                System.out.println("Setting lights to bright, cool tone for reading.");
                break;
            case "movie":
                System.out.println("Setting lights to dim, warm tone for movies.");
                break;
            case "default":
                System.out.println("Restoring default lighting.");
                break;
            default:
                System.out.println("Unknown scene. Keeping current lighting.");
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getCurrentScene() {
        return currentScene;
    }
}
