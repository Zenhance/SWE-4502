public class MotionDetectionSystem extends Subject {
    public void detectMotion(String location, String time) {
        String message = location + "," + time;
        notifyObservers(message);
    }
}
