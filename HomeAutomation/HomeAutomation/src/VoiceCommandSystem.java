public class VoiceCommandSystem implements Observer {
    private boolean voiceDetected=false;
    public void update(EnvironmentState state) {
        String voiceCommand = (String) state.getState("voiceCommand");
        if (voiceCommand != null) {
            voiceDetected=true;
            System.out.println("Processing voice command.");
        }
    }
    public boolean isVoiceDetected(){
        return voiceDetected;
    }
}
