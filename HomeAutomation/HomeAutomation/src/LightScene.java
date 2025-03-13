public class LightScene {
    public String name;
    public double brightnessLevel; // Brightness level from 0 to 100

    public LightScene(String name, double brightnessLevel) {
        this.name = name;
        this.brightnessLevel = brightnessLevel;
    }

    @Override
    public String toString() {
        return "LightScene{" +
                "name='" + name + '\'' +
                ", brightnessLevel=" + brightnessLevel +
                '}';
    }
}
