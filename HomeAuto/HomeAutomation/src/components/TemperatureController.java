package components;

public class TemperatureController implements core.Sensor
{
    @Override
    public void onStateChange(String newState) {
        if (newState.contains("cold")) {
            System.out.println("It's cold. Turning on heating.");
        } else if (newState.contains("hot")) {
            System.out.println("It's hot. Turning on cooling.");
        }
    }

    // Add a new method to the TemperatureController class
    public void onTemperatureChange(int newTemperature) {
        if (newTemperature < 20) {
            System.out.println("It's cold. Turning on heating.");
        } else if (newTemperature > 30) {
            System.out.println("It's hot. Turning on cooling.");
        }
    }



}
