public class EnvironmentState {
    public double temperature;
    public boolean motionDetected;
    public double lightLevel;

    public EnvironmentState() {}

    public EnvironmentState(double temperature, boolean motionDetected, double lightLevel) {
        this.temperature = temperature;
        this.motionDetected = motionDetected;
        this.lightLevel = lightLevel;
    }

    @Override
    public String toString() {
        return "EnvironmentState{" +
                "temperature=" + temperature +
                ", motionDetected=" + motionDetected +
                ", lightLevel=" + lightLevel +
                '}';
    }
}
