package VoiceCommandSystem;


import LightManagement.LightController;

public class LightOnCommand implements Command {
    private LightController lightController;

    public LightOnCommand(LightController lightController) {
        this.lightController = lightController;
    }

    @Override
    public void execute() {
        lightController.setScene("Reading");
        System.out.println("🔆 Light turned ON to Reading mode.");
    }
}
