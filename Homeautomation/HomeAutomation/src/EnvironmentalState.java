public class EnvironmentalState {
    private boolean motionDetected;
    private int temperature;
    private int lightLevel;
    private int powerUsage;

    public EnvironmentalState(boolean motionDetected, int temperature, int lightLevel, int powerUsage) {
        this.motionDetected = motionDetected;
        this.temperature = temperature;
        this.lightLevel = lightLevel;
        this.powerUsage = powerUsage;
    }

    public boolean isMotionDetected() { return motionDetected; }
    public int getTemperature() { return temperature; }
    public int getLightLevel() { return lightLevel; }
    public int getPowerUsage() { return powerUsage; }
}
