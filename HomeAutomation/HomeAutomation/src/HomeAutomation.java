import java.util.ArrayList;
import java.util.List;

public class HomeAutomation implements Subject{
    private List<Observer>observers=new ArrayList<>();
    private final EnvironmentState state=new EnvironmentState();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void updateState(String key,Object value){
        state.updateState(key,value);
        notifyObservers();
    }

    public void notifyObservers(){
        for (Observer observer:observers){
            observer.update(state);
        }
    }
}
