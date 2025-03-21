import java.util.HashSet;
import java.util.Set;

public class issueObserver  {
    private Set<Observer> observers = new HashSet<>();
    private CommandLogger logger = new CommandLogger();
    private StatisticsCollector statistics = new StatisticsCollector();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void executeCommand(Command command) {
        command.execute();
        logger.log(command);
        statistics.track(command);
        notifyObservers(command.getDescription());
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public CommandLogger getLogger() {
        return logger;
    }

    public StatisticsCollector getStatistics() {
        return statistics;
    }
}