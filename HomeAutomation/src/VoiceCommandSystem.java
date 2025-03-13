public class VoiceCommandSystem extends Subject {
    public void receiveVoiceCommand(String command) {
        notifyObservers(command);
    }
}
