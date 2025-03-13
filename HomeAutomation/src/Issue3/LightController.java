package Issue3;

import Issue1.IComponent;
import Issue1.StateManager;

public class LightController implements IComponent{
    private final StateManager stateManager;
    private int ambientLightLevel = 50;
    private boolean roomOccupied = false;
    private LightingSceneStrategy lightingSceneStrategy = new NormalLightingStrategy();
    private int brightness = 50;

    public LightController(StateManager stateManager) {
        this.stateManager = stateManager;
        this.stateManager.registerComponent("light_level", this);
        this.stateManager.registerComponent("room_occupancy", this);
        this.stateManager.registerComponent("lighting_scene", this);
    }

    @Override
    public void onStateChange(String key, Object newValue) {
        switch (key) {
            case "light_level":
                if (newValue instanceof Integer) {
                    this.ambientLightLevel = (Integer) newValue;
                }
                break;
            case "room_occupancy":
                if (newValue instanceof Boolean) {
                    this.roomOccupied = (Boolean) newValue;
                }
                break;
            case "lighting_scene":
                if (newValue instanceof LightingSceneStrategy) {
                    this.lightingSceneStrategy = (LightingSceneStrategy) newValue;
                }
                break;
        }
        adjustLighting();
    }

    public void adjustLighting() {
        int baseLevel = lightingSceneStrategy.getBaseLevel();
        int ambientAdjustment = lightingSceneStrategy.calculateAmbientAdjustment(ambientLightLevel);
        int occupancyAdjustment = lightingSceneStrategy.calculateOccupancyAdjustment(roomOccupied);

        brightness = Math.max(0, Math.min(100, baseLevel + ambientAdjustment + occupancyAdjustment));
        stateManager.updateState("brightness", brightness);
    }

    public int getBrightness() {
        return brightness;
    }

    public void setLightingSceneStrategy(LightingSceneStrategy lightingSceneStrategy) {
        this.lightingSceneStrategy = lightingSceneStrategy;
        adjustLighting();
    }
}
