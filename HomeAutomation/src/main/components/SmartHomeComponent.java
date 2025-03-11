package main.components;

import java.util.Map;

public interface SmartHomeComponent {

    void initialize();

    void handleCommand(String command, Object... params);

    Map<String, Object> getStatus();
}