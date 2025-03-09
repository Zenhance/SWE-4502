package Lab_11_210042166.Issue_1.Storage_Class;

public class EnvironmentState {
    private double temperature;
    private boolean motionDetected;
    private int lightLevel;

    public EnvironmentState(double temperature, boolean motionDetected, int lightLevel){
        this.temperature=temperature;
        this.motionDetected=motionDetected;
        this.lightLevel=lightLevel;
    }
}
