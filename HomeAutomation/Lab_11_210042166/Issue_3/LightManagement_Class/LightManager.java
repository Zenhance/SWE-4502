package Lab_11_210042166.Issue_3.LightManagement_Class;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;

public class LightManager implements Component {

    private boolean lightsOn;
    private int ambientLightThreshold;
    private boolean isOccupied;
    private String currentScene;

    public static final int LOW_LIGHT_THRESHOLD = 50;
    public static final int BRIGHT_LIGHT_THRESHOLD = 150;

    public LightManager(int ambientLightThreshold) {
        this.ambientLightThreshold = ambientLightThreshold;
        this.lightsOn = false;
        this.isOccupied = false;
        this.currentScene = "normal";
    }
    public void setScene(String scene) {
        this.currentScene = scene;
    }

    public void setSceneLighting(String scene) {
        switch (scene) {
            case "reading":
                System.out.println("Setting lights to bright for reading.");
                break;
            case "movie":
                System.out.println("Setting lights to dim for movie watching.");
                break;
            case "normal":
            default:
                System.out.println("Setting lights to normal level.");
                break;
        }
    }
    @Override
    public void update(EnvironmentState state) {
        if (state.isMotionDetected()) {
            isOccupied = true;
        } else {
            isOccupied = false;
        }

        adjustLighting(state.getLightLevel());
    }

    public void adjustLighting(int lightLevel) {
        if (isOccupied) {
            if (lightLevel < ambientLightThreshold) {
                if (!lightsOn) {
                    lightsOn = true;
                    System.out.println("Lights turned ON due to low light level and room occupancy.");
                }
            } else {
                if (lightsOn) {
                    lightsOn = false;
                    System.out.println("Lights turned OFF due to sufficient light level.");
                }
            }
        } else {
            if (lightsOn) {
                lightsOn = false;
                System.out.println("Lights turned OFF due to no occupancy.");
            }
        }

        setSceneLighting(currentScene);
    }



    public boolean areLightsOn() {
        return lightsOn;
    }


}
