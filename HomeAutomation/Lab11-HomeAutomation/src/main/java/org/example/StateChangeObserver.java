package org.example;

// Observer interface for components to implement
interface StateChangeObserver {
    void onStateChange(String property, Object oldValue, Object newValue);
}