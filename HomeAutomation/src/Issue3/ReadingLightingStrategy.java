package Issue3;

public class ReadingLightingStrategy implements LightingSceneStrategy {
    @Override
    public int getBaseLevel() {
        return 70;
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
