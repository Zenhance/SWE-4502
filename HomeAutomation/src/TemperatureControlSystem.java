public class TemperatureControlSystem extends Subject {
    public void changeTemperature(String temperature, String room) {
        String message = temperature + "," + room;
        notifyObservers(message);
    }
}
