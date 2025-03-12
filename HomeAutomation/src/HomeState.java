
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeState implements ISubject {
    private Map<String, Object> currentStates;
    private List<IObserver> observers;
    private List<StateChange> history;

    public HomeState() {
        currentStates = new HashMap<>();
        observers = new ArrayList<>();
        history = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stateName, Object value) {
        for (IObserver observer : observers) {
            observer.update(stateName, value);
        }
    }

    public void setState(String stateName, Object value) {
        currentStates.put(stateName, value);
        history.add(new StateChange(stateName, value));
        notifyObservers(stateName, value);
    }

    public Object getState(String stateName) {
        return currentStates.get(stateName);
    }

    public List<StateChange> getHistory() {
        return new ArrayList<>(history);
    }
}