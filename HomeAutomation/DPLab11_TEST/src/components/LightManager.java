package components;

import core.IComponent;

public class LightManager implements IComponent {

    @Override
    public void onStateChanged(String newState, int value) {
        if (newState.contains("dark")) {
            System.out.println("It's dark. Turning on lights.");
        }
        if (newState.contains("bright")) {
            System.out.println("It's bright. Turning off lights.");
        }
    }

    public void adjustLighting(boolean occupied) {
        if (occupied) {
            System.out.println("Room is occupied. Turning on lights.");
        } else {
            System.out.println("Room is unoccupied. Turning off lights.");
        }
    }

    public void setScene(String scene) {
        switch (scene) {
            case "reading":
                System.out.println("Setting lighting for reading.");
                break;
            case "movie":
                System.out.println("Setting lighting for movie watching.");
                break;
            case "relaxing":
                System.out.println("Setting lighting for relaxing.");
                break;
            default:
                System.out.println("Scene not recognized.");
        }
    }
}
