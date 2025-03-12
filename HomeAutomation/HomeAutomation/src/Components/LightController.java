package Components;

import Core.Observer;
import Core.SmartHomeData;

import java.util.HashMap;
import java.util.Map;

public class LightController implements Observer {
    private final SmartHomeData homeData;
    private boolean lightsOn = false;
    private static final Map<String, Integer> SCENE_BRIGHTNESS = new HashMap<>();

    static {
        SCENE_BRIGHTNESS.put("Reading", 80);
        SCENE_BRIGHTNESS.put("Movie", 30);
    }

    public LightController(SmartHomeData homeData) {
        this.homeData = homeData;
    }

    @Override
    public void update(String state, Object value) {
        if ("LIGHT_LEVEL".equals(state)) {
            int lightLevel = (Integer) value;
            homeData.addReading("LIGHT_LEVEL", lightLevel);
            lightsOn = lightLevel < 50;
            System.out.println("LightController: Lights " + (lightsOn ? "ON" : "OFF"));
        }
    }

    public boolean areLightsOn() {
        return lightsOn;
    }
}
