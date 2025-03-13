import java.util.HashMap;
import java.util.Map;

public class LightController implements Observer {
    private boolean lightsOn = false;
    private String currentScene = "Default";
    private static final Map<String, Integer> SCENE_BRIGHTNESS = new HashMap<>();

    static {
        SCENE_BRIGHTNESS.put("Reading", 80);
        SCENE_BRIGHTNESS.put("Movie", 30);
        SCENE_BRIGHTNESS.put("Default", 60);
    }

    @Override
    public void update(String state, Object value) {
        if (state.equals("LIGHT_LEVEL")) {
            int lightLevel = (Integer) value;
            lightsOn = lightLevel < 50; // Turn on lights if too dark
            System.out.println("LightController: Lights turned " + (lightsOn ? "ON" : "OFF"));
        }
    }

    public void setScene(String scene) {
        if (SCENE_BRIGHTNESS.containsKey(scene)) {
            currentScene = scene;
            System.out.println("LightController: Scene set to " + scene + " with brightness " + SCENE_BRIGHTNESS.get(scene));
        } else {
            System.out.println("LightController: Scene not recognized.");
        }
    }
}