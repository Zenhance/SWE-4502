public class LightControlSystem extends Subject {
    public void changeLightStatus(int lightLevel, boolean roomOccupied, String room) {
        String message = lightLevel + "," + roomOccupied + "," + room;
        notifyObservers(message);
    }
}
