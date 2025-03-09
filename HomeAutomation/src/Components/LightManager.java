package Components;

import Core_Models.IObserver;
import Core_Models.SystemState;

public class LightManager implements IObserver {
    public int lightLevel;
    public int changedLightLevel;
    public boolean roomOccupied;
    public String scene;

    public void update(SystemState state){
        this.lightLevel = state.lightLevel;
        this.roomOccupied = state.roomOccupied;
        if (!roomOccupied) {
            changedLightLevel = 0;
            scene = "Off";
        } else {
            if (lightLevel < 30) {
                changedLightLevel = 70;
                scene = "Reading";
            } else if (lightLevel >= 30 && lightLevel <= 70) {
                changedLightLevel = 60;
                scene = "Normal";
            } else {
                changedLightLevel = 30;
                scene = "Movie";
            }
        }
        System.out.println("Lighting Adjusted: Scene - " + scene + ", changedLight Level - " + changedLightLevel);

    }

    public int getChangedLightLevel() {
        return changedLightLevel;
    }

    public String getScene() {
        return scene;
    }
}
