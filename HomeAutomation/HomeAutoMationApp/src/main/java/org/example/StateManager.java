package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StateManager {
    private static StateManager instance;
    private List<IStateObserver> observers = new ArrayList<>();
    private EnvironmentalState currentState = new EnvironmentalState();

    StateManager() {}

    public static synchronized StateManager getInstance() {
        if (instance == null) {
            instance = new StateManager();
        }
        return instance;
    }

    public void registerObserver(IStateObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (IStateObserver observer : observers) {
            observer.update(currentState);
        }
    }

    public void updateState(Consumer<EnvironmentalState> updateFunction) {
        updateFunction.accept(currentState);
        notifyObservers();
    }
}
