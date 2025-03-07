package models;

public class EnvironmentState {
    private boolean motionDetected;
    private double temperature;
    private double lightLevel;
    private double powerUsage;
    private String voiceCommand;

    public void setMotionDetected(boolean motionDetected) {
        this.motionDetected = motionDetected;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setLightLevel(double lightLevel) {
        this.lightLevel = lightLevel;
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }

    public void setVoiceCommand(String voiceCommand) {
        this.voiceCommand = voiceCommand;
    }

    public boolean isMotionDetected() {
        return motionDetected;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLightLevel() {
        return lightLevel;
    }

    public double getPowerUsage() {
        return powerUsage;
    }

    public String getVoiceCommand() {
        return voiceCommand;
    }
}
