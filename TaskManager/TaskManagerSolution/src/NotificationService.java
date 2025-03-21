import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int notificationCount = 0;

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Command command) {
        notificationCount++;
        for (Observer observer : observers) {
            observer.update(command);
        }
    }
    public int getNotificationCount() {
        return notificationCount;
    }
}
