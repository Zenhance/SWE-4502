import java.util.ArrayList;
import java.util.List;

public class StateManager {
    private State currentState;
    private List<StateObserver> observers;

    public StateManager() {
        this.currentState = new State();
        this.observers = new ArrayList<>();
    }

    public void registerObserver(StateObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(StateObserver observer) {
        observers.remove(observer);
    }

    public void updateTemperature(double temperature) {
        currentState.setTemperature(temperature);
        notifyObservers();
    }

    public void updateHumidity(double humidity) {
        currentState.setHumidity(humidity);
        notifyObservers();
    }

    public void updateLightStatus(boolean status) {
        currentState.setLightStatus(status);
        notifyObservers();
    }

    public void updateSecurityStatus(boolean status) {
        currentState.setSecurityStatus(status);
        notifyObservers();
    }

    private void notifyObservers() {
        for (StateObserver observer : observers) {
            observer.onStateChange(currentState);
        }
    }

    public State getCurrentState() {
        return currentState;
    }
}