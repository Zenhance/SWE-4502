public class TemperatureControlSystem extends Subject {
    public void changeTemperature(int temperature, String room) {
        String message = temperature + "," + room;
        notifyObservers(message);
    }
}
