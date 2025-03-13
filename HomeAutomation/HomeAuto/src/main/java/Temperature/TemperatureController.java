package Temperature;

import Core.Observer;

public class TemperatureController implements Observer {
    private boolean heaterOn;
    private boolean coolerOn;
    private final int targetHeatingTemperature = 18;  // Temperature below which heating is activated
    private final int targetCoolingTemperature = 25;  // Temperature above which cooling is activated
    private final int hysteresisBuffer = 2;  // Buffer zone to prevent rapid cycling (degrees)

    @Override
    public void update(String eventType, Object value) {
        if(eventType.equals("temperature")){
            int currentTemperature = (int) value;
            controlTemperature(currentTemperature);
        }
    }

    private void controlTemperature(int currentTemperature) {
        if (currentTemperature < targetHeatingTemperature - hysteresisBuffer) {
            heaterOn = true;
            coolerOn = false;  // Ensure the cooler is off when heating is on
        }
        else if (currentTemperature > targetCoolingTemperature + hysteresisBuffer) {
            coolerOn = true;
            heaterOn = false;  // Ensure the heater is off when cooling is on
        }
        else if (currentTemperature >= targetHeatingTemperature + hysteresisBuffer &&
                currentTemperature <= targetCoolingTemperature - hysteresisBuffer) {
            heaterOn = false;
            coolerOn = false;
        }
    }


    public boolean isHeaterOn() {
        return heaterOn;
    }

    // Getter for whether the cooler is on
    public boolean isCoolerOn() {
        return coolerOn;
    }
}
