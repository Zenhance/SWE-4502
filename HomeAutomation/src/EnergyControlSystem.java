public class EnergyControlSystem extends Subject {
    public void changeEnergyUsage(double energyUsage, String room) {
        String message = energyUsage + "," + room;
        notifyObservers(message);
    }
}
