public class EnvironmentalState {
    public boolean motionDetected;
    public int temperature;
    public int lightLevel;
    public int powerUsage;
    public boolean roomOccupied;


    public boolean isMotionDetected() { return motionDetected; }
    public int getTemperature() { return temperature; }
    public int getLightLevel() { return lightLevel; }
    public int getPowerUsage() { return powerUsage; }
}
