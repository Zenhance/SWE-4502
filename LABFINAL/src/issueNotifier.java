



import java.util.ArrayList;
import java.util.List;

class IssueNotifier {
    private CommandLogger logger = new CommandLogger();
    private StatisticsCollector statistics = new StatisticsCollector();
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public void executeCommand(Command command) {
        command.execute();
        logger.log(command);
        statistics.track(command);
        notifyObservers(command.getDescription());
    }
}


