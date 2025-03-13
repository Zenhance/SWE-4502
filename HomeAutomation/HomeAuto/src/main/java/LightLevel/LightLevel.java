package LightLevel;

import Core.Observer;

public class LightLevel implements Observer {

    private boolean lightOn;
    private String currentScene;
    private static final String READING_SCENE = "reading";
    private static final String MOVIE_SCENE = "movieWatching";
    private static final String DEFAULT_SCENE = "default";

    // These values simulate different scene brightness levels (from 0 to 100)
    private static final int READING_BRIGHTNESS = 60;
    private static final int MOVIE_BRIGHTNESS = 20;
    private static final int DEFAULT_BRIGHTNESS = 50;

    private boolean isRoomOccupied;

    @Override
    public void update(String eventType, Object value) {
        if(eventType.equals("lightLevel")){
            adjustLightingBasedOnLightLevel((int) value);
        }
        else if(eventType.equals("occupancy")){
            isRoomOccupied= (boolean) value;
            adjustLightingForOccupancy();
        }
        else{
            currentScene = (String) value;
            adjustLightingForScene();
        }
    }

    private void adjustLightingBasedOnLightLevel(int lightLevel) {
        if (lightLevel <= 50 && isRoomOccupied) {
            lightOn = true; // Turn on light if ambient light is low and room is occupied
        } else {
            lightOn = false; // Otherwise, turn off light
        }
    }

    private void adjustLightingForOccupancy() {
        if (!isRoomOccupied) {
            lightOn = false; // Turn off light if room is not occupied
        } else {
            adjustLightingForScene(); // Re-apply scene lighting if room is occupied
        }
    }

    private void adjustLightingForScene() {
        if (currentScene == null) {
            currentScene = DEFAULT_SCENE;
        }

        switch (currentScene) {
            case READING_SCENE:
                lightOn = true; // Lights are on for reading, set brightness to READING_BRIGHTNESS
                break;
            case MOVIE_SCENE:
                lightOn = true; // Dim the light for movie watching, set brightness to MOVIE_BRIGHTNESS
                break;
            default:
                lightOn = true; // Default lighting if no specific scene is selected, set to DEFAULT_BRIGHTNESS
                break;
        }
    }


    private boolean isLightOn(){
        return lightOn;
    }
}
