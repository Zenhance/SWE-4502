package Issue5;


public class DevicePower {
    private final String deviceId;
    private final double powerUsage;

    public DevicePower(String deviceId, double powerUsage) {
        this.deviceId = deviceId;
        this.powerUsage = powerUsage;
    }

    public String getDeviceId() { return deviceId; }
    public double getPowerUsage() { return powerUsage; }
}
