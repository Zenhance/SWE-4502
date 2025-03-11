package light;

import core.Event;
import core.EventListener;
import core.model.EventType;
import core.StateManager;
import core.model.Measurement;

public class LightManager implements EventListener {
    private StateManager stateManager;
    private int ambientLightLevel = 50;
    private boolean roomOccupied = false;
    private String currentScene = "Normal";

    public LightManager(StateManager stateManager) {
        this.stateManager = stateManager;
        stateManager.register(EventType.LIGHT_LEVEL, this);
        stateManager.register(EventType.OCCUPANCY, this);
    }

    public void adjustLighting() {
        if (roomOccupied) {
            switch (currentScene) {
                case "Reading":
                    setLightLevel(75);
                    break;
                case "Movie":
                    setLightLevel(25);
                    break;
                default:
                    setLightLevel(ambientLightLevel > 60 ? 40 : 80);
                    break;
            }
        } else {
            setLightLevel(30);
        }
    }

    public void setScene(String scene) {
        this.currentScene = scene;
        adjustLighting();
    }

    private void setLightLevel(int level) {
        Measurement measurement = new Measurement(level, Measurement.Units.PERCENT);
        stateManager.setState(EventType.LIGHT_ADJUSTMENT, measurement);
    }

    public String getCurrentScene() {
        return currentScene;
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType() == EventType.LIGHT_LEVEL) {
            ambientLightLevel = (int) ((Measurement) event.getData()).getValue();
            adjustLighting();
        } else if (event.getType() == EventType.OCCUPANCY) {
            roomOccupied = ((Measurement) event.getData()).getValue() > 0;
            adjustLighting();
        }
    }
}
