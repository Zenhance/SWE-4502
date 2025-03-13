package components;

import core.IComponent;

public class HomeComponent implements IComponent {
    private String name;
    private boolean notified;

    public HomeComponent(String name) {
        this.name = name;
        this.notified = false; // Initially, the component is not notified
    }

    @Override
    public void onStateChanged(String state, int value) {
        System.out.println("Component " + name + " notified of state change: " + state + " = " + value);
        this.notified = true;
    }

    public boolean isNotified() {
        return notified;
    }
}
