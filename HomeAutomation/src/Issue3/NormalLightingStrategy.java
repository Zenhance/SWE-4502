package Issue3;

public class NormalLightingStrategy implements LightingSceneStrategy {
    @Override
    public int getBaseLevel() {
        return 50;
    }

    @Override
    public int calculateAmbientAdjustment(int ambientLightLevel) {
        return Math.max(0, 50 - ambientLightLevel) / 2;
    }

    @Override
    public int calculateOccupancyAdjustment(boolean roomOccupied) {
        return roomOccupied ? 0 : -30;
    }
}
