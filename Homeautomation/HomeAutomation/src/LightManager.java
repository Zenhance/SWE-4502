public class LightManager implements Observer {
    private boolean isOccupied;
    public int ambientLightLevel;
    private String currentScene;
    private int brightnessLevel;

    public LightManager() {
        this.isOccupied = false;
        this.ambientLightLevel = 0;
        this.currentScene = "default";
        this.brightnessLevel = 70; // Default brightness
    }

    @Override
    public void update(EnvironmentalState state) {
        this.isOccupied = state.roomOccupied;
        this.ambientLightLevel = state.getLightLevel();
        adjustLighting();
    }

    private void adjustLighting() {
        if (!isOccupied) {
            System.out.println("Room is unoccupied. Turning off lights.");
            brightnessLevel = 0;
            currentScene="Off";
            //return;
        }else{


            if (currentScene.equals("reading")) {
                brightnessLevel = 100;
            } else if (currentScene.equals("movie")) {
                brightnessLevel = 30;
            } else if (currentScene.equals("relax")) {
                brightnessLevel = 50;
            }
            else if(currentScene.equals("Off")){
                brightnessLevel=0;
            }
            else {
                brightnessLevel = 70; // Default scene
            }

            if (ambientLightLevel < 40) {
                System.out.println(ambientLightLevel);
                System.out.println("Low ambient light detected. Setting brightness to " + brightnessLevel + "%.");
            } else if (ambientLightLevel > 80) {
                System.out.println("High ambient light detected. Reducing brightness."+ ambientLightLevel);
                System.out.println("Befor reducing."+ brightnessLevel);
                brightnessLevel = Math.max(brightnessLevel - 20, 10);
                System.out.println("After reducing."+ brightnessLevel);
            } else {
                System.out.println("Maintaining current lighting level at " + brightnessLevel + "%.");
            }
        }}

    public void setScene(String scene) {
        if (scene.equals("reading") || scene.equals("movie") || scene.equals("relax") || scene.equals("default")) {
            this.currentScene = scene;
            System.out.println("Scene set to: " + scene);
            adjustLighting();
        } else {
            System.out.println("Invalid scene: " + scene);
        }
    }

    public int getBrightnessLevel() {
        System.out.println("Scene set to: " + brightnessLevel);

        return brightnessLevel;
    }
}
