package LightManagement;

// Defines different lighting scenes
public class LightScene {
    private String name;
    private int brightness;

    public LightScene(String name, int brightness) {
        this.name = name;
        this.brightness = brightness;
    }

    public String getName() {
        return name;
    }

    public int getBrightness() {
        return brightness;
    }
}
