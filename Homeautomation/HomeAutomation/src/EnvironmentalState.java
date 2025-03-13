public class EnvironmentalState {
   public boolean motionDetected;
   public int temperature;
   public int lightLevel;
   public int powerUsage;

    public EnvironmentalState(boolean motionDetected, int temperature, int lightLevel, int powerUsage) {
        this.motionDetected = motionDetected;
        this.temperature = temperature;
        this.lightLevel = lightLevel;
        this.powerUsage = powerUsage;
    }

}
