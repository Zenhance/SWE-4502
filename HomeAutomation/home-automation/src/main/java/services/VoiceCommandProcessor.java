package services;
import subjects.HomeAutomationSystem;

public class VoiceCommandProcessor {
    private HomeAutomationSystem homeAutomationSystem;

    public VoiceCommandProcessor(HomeAutomationSystem homeAutomationSystem) {
        this.homeAutomationSystem = homeAutomationSystem;
    }

    public void processCommand(String command) {
        switch (command.toLowerCase()) {
            case "turn on the lights":
                homeAutomationSystem.getEnvironmentState().setLightLevel(100);
                break;
            case "turn off the lights":
                homeAutomationSystem.getEnvironmentState().setLightLevel(0);
                break;
            case "increase temperature":
                double newTemp = homeAutomationSystem.getEnvironmentState().getTemperature() + 2;
                homeAutomationSystem.getEnvironmentState().setTemperature(newTemp);
                break;
            case "decrease temperature":
                newTemp = homeAutomationSystem.getEnvironmentState().getTemperature() - 2;
                homeAutomationSystem.getEnvironmentState().setTemperature(newTemp);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
