package VoiceCommandSystem;


import TemperatureControl.TemperatureController;

public class TemperatureSetCommand implements Command {
    private TemperatureController temperatureController;
    private int targetTemperature;

    public TemperatureSetCommand(TemperatureController temperatureController, int targetTemperature) {
        this.temperatureController = temperatureController;
        this.targetTemperature = targetTemperature;
    }

    @Override
    public void execute() {
        System.out.println("🌡️ Temperature set to " + targetTemperature + "°C.");
    }
}
