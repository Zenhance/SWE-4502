public class LightManager implements IObserver {

    private String lastAction;

    @Override
    public void update(SystemState state) {
        String description = state.getStateDescription();

        if (description.equals("Dark")) {
            lastAction = "It's dark, turning on the lights...";
        } else if (description.equals("Bright")) {
            lastAction = "It's bright, turning off the lights...";
        }
         else if (description.equals("Room Unoccupied")) {
            turnOffLights();
        }
    }




    private void turnOffLights() {
        lastAction = "Turning off the lights...";
    }


    public String getLastAction() {
        return lastAction;
    }
}
