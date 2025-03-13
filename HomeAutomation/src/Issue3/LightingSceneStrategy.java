package Issue3;

public interface LightingSceneStrategy {
    int getBaseLevel();
    int calculateAmbientAdjustment(int ambientLightLevel);
    int calculateOccupancyAdjustment(boolean roomOccupied);
}
