package CoreFramework;

import CoreFramework.EnvironmentState;

// Example observer that logs state updates
public class LoggingComponent implements Observer {
    private String componentName;

    public LoggingComponent(String name) {
        this.componentName = name;
    }

    @Override
    public void update(EnvironmentState state) {
        System.out.println(componentName + " received update: " + state);
    }
}
