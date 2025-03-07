package observers;

import models.EnvironmentState;

public class LightController implements Observer {
    private double lightLevel;

    @Override
    public void update(EnvironmentState environmentState) {
        this.lightLevel = environmentState.getLightLevel();
        if (lightLevel > 90) {
            System.out.println("Light is too bright.");
        } else if (lightLevel > 60) {
            System.out.println("Light is bright.");
        } else {
            System.out.println("Light is dim.");
        }
    }

    public double getLightLevel() {
        return lightLevel;
    }
}
