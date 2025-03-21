import java.util.*;

public class NotificationService {
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}
