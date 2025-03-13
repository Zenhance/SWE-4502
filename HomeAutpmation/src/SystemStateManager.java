import java.util.ArrayList;
import java.util.List;

public class SystemStateManager {
    private List<IObserver> observers = new ArrayList<>();
    private SystemState state;

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

}
