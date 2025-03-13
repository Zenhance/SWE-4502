package main.Code.components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;

public interface TemperatureController extends HomeSystemObserver {
    void setTargetTemperature(String room, double temperature);
    double getTargetTemperature(String room);
    double getCurrentTemperature(String room);
    void updateTemperature(String room, double temperature);
    boolean isHeatingActive(String room);
    boolean isCoolingActive(String room);
}
