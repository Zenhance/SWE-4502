import java.util.ArrayList;
import java.util.List;

public class HomeAutomationSystem  {
    private List<Observer> observers;
    private EnvironmentalState state;

    public HomeAutomationSystem() {
        this.observers = new ArrayList<>();
        this.state = new EnvironmentalState(false, 22, 50, 100); // Default state
    }
}
