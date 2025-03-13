public class LightManager implements IObserver {

    private String lastAction;

    public void update(SystemState state) {
        String description = state.getStateDescription();

        if (description.equals("Dark")) {
            lastAction = "It's dark, turning on the lights...";
        } else if (description.equals("Bright")) {
            lastAction = "It's bright, turning off the lights...";
        } else if (description.equals("Room Occupied")) {
            setLightingScene("Reading");
        } else if (description.equals("Room Unoccupied")) {
            turnOffLights();
        }
    }


    private void setLightingScene(String scene) {
        switch (scene) {
            case "Reading":
                lastAction = "Setting lighting scene to Reading.";
                break;
            case "Movie":
                lastAction = "Setting lighting scene to Movie.";
                break;
            default:
                lastAction = "Setting default lighting scene.";
                break;
        }
    }




    private void turnOffLights() {
        lastAction = "Turning off the lights...";
    }


    public String getLastAction() {
        return lastAction;
    }
}
