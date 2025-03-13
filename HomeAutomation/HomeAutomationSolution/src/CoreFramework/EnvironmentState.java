package CoreFramework;

// Represents environmental data
public class EnvironmentState {
    private boolean motionDetected;
    private int temperature;
    private int lightLevel;

    public EnvironmentState(boolean motionDetected, int temperature, int lightLevel) {
        this.motionDetected = motionDetected;
        this.temperature = temperature;
        this.lightLevel = lightLevel;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getLightLevel() {
        return lightLevel;
    }

    @Override
    public String toString() {
        return "CoreFramework.EnvironmentState{" +
                "motionDetected=" + motionDetected +
                ", temperature=" + temperature +
                ", lightLevel=" + lightLevel +
                '}';
    }
}
