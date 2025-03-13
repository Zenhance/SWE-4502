package org.example;

import java.util.ArrayList;

public class StateManager {
    private static StateManager instance;
    private List<StateObserver> observers = new ArrayList<>();
    private EnvironmentalState currentState = new EnvironmentalState();

    StateManager() {}

    public static synchronized StateManager getInstance() {
        if (instance == null) {
            instance = new StateManager();
        }
        return instance;
    }

    public void registerObserver(StateObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (StateObserver observer : observers) {
            observer.update(currentState);
        }
    }

    public void updateState(Consumer<EnvironmentalState> updateFunction) {
        updateFunction.accept(currentState);
        notifyObservers();
    }
}
