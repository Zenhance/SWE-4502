public class LightControlSystem extends Subject {
    public void changeLightStatus(String lightStatus, String room) {
        String message = lightStatus + "," + room;
        notifyObservers(message);
    }
}
