public class EnvironmentState
{
    private boolean motionDetected;
    private double temperature;
    private double lightLevel;
    private double powerUsage;
    private String voiceCommand;


    public boolean isMotionDetected() {
        return motionDetected;
    }

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // Getter and Setter for lightLevel
    public double getLightLevel() {
        return lightLevel;
    }

    public void setLightLevel(double lightLevel) {
        this.lightLevel = lightLevel;
    }


    public double getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }

    public String getVoiceCommand() {
        return voiceCommand;
    }

    public void setVoiceCommand(String voiceCommand) {
        this.voiceCommand = voiceCommand;
    }
}
