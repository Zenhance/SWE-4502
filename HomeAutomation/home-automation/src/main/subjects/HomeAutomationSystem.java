public class HomeAutomationSystem implements Subject {
    private List<Observer> observers;
    private EnvironmentState environmentState;

    public HomeAutomationSystem() {
        observers = new ArrayList<>();
        environmentState = new EnvironmentState();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setEnvironmentState(EnvironmentState environmentState) {
        this.environmentState = environmentState;
        notifyObservers();
    }
}
