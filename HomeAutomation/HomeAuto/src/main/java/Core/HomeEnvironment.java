package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeEnvironment {
    private static HomeEnvironment instance;
    private final Map<String, Object> state= new HashMap<>();
    private final Map<String, List<Observer>> observers= new HashMap<>();

    private HomeEnvironment(){}

    public static HomeEnvironment getInstance(){
        if(instance== null){
            instance= new HomeEnvironment();
        }
        return instance;
    }

    public void registerObserver(String eventType, Observer observer) {
        observers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
    }

    public void removeObserver(String eventType, Observer observer){
        List <Observer> observerList= observers.get(eventType);
                if(observerList!=null){
                    observerList.remove(observer);
                }
    }

    public void setState(String eventType, Object value){
        state.put(eventType, value);
        notifyObservers(eventType, value);
    }

    public Object getState(String eventType){
        return state.get(eventType);
    }

    public void notifyObservers(String eventType, Object value){
        List <Observer> observerList= observers.get(eventType);
        if(observerList!=null){
            for(Observer i: observerList){
                i.update(eventType, value);
            }
        }
    }








}
