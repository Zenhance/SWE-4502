package components;

import core.EventType;
import core.HomeSystem;
import core.HomeSystemObserver;
import java.util.List;
import java.util.Map;

public interface VoiceCommandProcessor extends HomeSystemObserver {
    void processCommand(String command);
    List<String> getCommandHistory();
    Map<String, Object> parseCommand(String command);
}
