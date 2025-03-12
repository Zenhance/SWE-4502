import java.util.ArrayList;
import java.util.List;

public class EnvironmentState {
    private List<Observer> observers = new ArrayList<>();
    private String state;
    private Object value;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String state, Object value) {
        this.state = state;
        this.value = value;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state, value);
        }
    }
}
