package Commands;

import CoreFramework.HomeEnvironment;
import CoreFramework.Observer;

public class SetTemperatureCommand implements Command {
    private final double temperature;

    public SetTemperatureCommand(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void execute(){
        HomeEnvironment.getInstance().setState("targetTemperature", temperature);
    }
}
