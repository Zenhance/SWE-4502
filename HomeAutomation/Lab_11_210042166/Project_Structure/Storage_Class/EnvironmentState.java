package Lab_11_210042166.Project_Structure.Storage_Class;

public class EnvironmentState {
    private double temperature;
    private boolean motionDetected;
    private int lightLevel;

    public EnvironmentState(double temperature, boolean motionDetected, int lightLevel){
        this.temperature=temperature;
        this.motionDetected=motionDetected;
        this.lightLevel=lightLevel;
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
}
