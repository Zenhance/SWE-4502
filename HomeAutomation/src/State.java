public class State {
    private double temperature;
    private double humidity;
    private boolean lightStatus;
    private boolean securityStatus;

    public State() {
        this.temperature = 0.0;
        this.humidity = 0.0;
        this.lightStatus = false;
        this.securityStatus = false;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public boolean isLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(boolean lightStatus) {
        this.lightStatus = lightStatus;
    }

    public boolean isSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(boolean securityStatus) {
        this.securityStatus = securityStatus;
    }

    @Override
    public String toString() {
        return "Environmental State:\n" +
                "Temperature: " + temperature + "°C\n" +
                "Humidity: " + humidity + "%\n" +
                "Lights: " + (lightStatus ? "ON" : "OFF") + "\n" +
                "Security System: " + (securityStatus ? "ARMED" : "DISARMED");
    }
}