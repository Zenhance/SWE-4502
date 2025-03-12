package Lab_11_210042166.Project_Structure.Storage_Class;

public class EnvironmentState {
    private double temperature;
    private boolean motionDetected;
    private int lightLevel;
    private double powerUsage;


    public EnvironmentState(double temperature, boolean motionDetected, int lightLevel,double powerUsage){
        this.temperature=temperature;
        this.motionDetected=motionDetected;
        this.lightLevel=lightLevel;
        this.powerUsage = powerUsage;

    }

    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isMotionDetected(){
        return motionDetected;
    }
    public int getLightLevel(){
        return lightLevel;
    }
    public double getPowerUsage() {
        return powerUsage;
    }
    public void setLightsOn(boolean lightsOn) {
        if (lightsOn) {
            this.lightLevel = 100;
        } else {
            this.lightLevel = 0;
        }
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }
}
