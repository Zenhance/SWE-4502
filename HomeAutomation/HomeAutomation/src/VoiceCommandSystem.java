public class VoiceCommandSystem implements Observer {
    @Override
    public void update(EnvironmentState state) {
        String voiceCommand = (String) state.getState("voiceCommand");
        if (voiceCommand != null) {
            System.out.println("Processing voice command: " + voiceCommand);
        }
    }
}
