import java.util.ArrayList;
import java.util.List;

public class Notification {


    private final List<IssueObserver> observers = new ArrayList<>();

    public void registerObserver(IssueObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IssueObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (IssueObserver observer : observers) {
            observer.notify(message);
        }

    }


}


