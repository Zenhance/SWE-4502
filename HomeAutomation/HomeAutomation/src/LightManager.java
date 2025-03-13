import java.util.HashMap;
import java.util.Map;

public class LightManager implements Observer {
    public boolean lightsOn;
    public double currentBrightness;
    public LightScene currentScene;
    public Map<String, LightScene> scenes = new HashMap<>();

    public LightManager() {
        // Predefined scenes
        scenes.put("Reading", new LightScene("Reading", 80));
        scenes.put("Movie", new LightScene("Movie", 30));
        scenes.put("Relax", new LightScene("Relax", 50));
    }

    @Override
    public void update(EnvironmentState state) {
        adjustLightsBasedOnState(state);
    }

    // Adjust lights based on light level and motion detection
    private void adjustLightsBasedOnState(EnvironmentState state) {
        if (state.motionDetected && state.lightLevel < 40) {
            turnOnLights(70); // Turn on lights if dark and motion detected
        } else if (state.motionDetected && state.lightLevel >= 40) {
            turnOffLights(); // Turn off lights if enough natural light
        } else if (!state.motionDetected) {
            turnOffLights(); // Turn off lights if no motion
        }
    }


    public void turnOnLights(double brightness) {
        lightsOn = true;
        currentBrightness = brightness;
        System.out.println("Lights turned ON with brightness: " + brightness);
    }

    public void turnOffLights() {
        lightsOn = false;
        currentBrightness = 0;
        System.out.println("Lights turned OFF.");
    }

    // Set a specific scene
    public void setScene(String sceneName) {
        LightScene scene = scenes.get(sceneName);
        if (scene != null) {
            currentScene = scene;
            turnOnLights(scene.brightnessLevel);
            System.out.println("Scene set to: " + scene);
        } else {
            System.out.println("Scene '" + sceneName + "' not found.");
        }
    }
}
