import java.util.*;

/**
 * The core state management system using Observer pattern to notify components
 * of environmental changes.
 */
public class HomeEnvironmentState {
    private static HomeEnvironmentState instance;
    private final Map<String,Object> stateValues= new HashMap<>();
    private final Map<String, List<EnvironmentObserver>>observers=new HashMap<>();


    //Singleton Pattern
    private HomeEnvironmentState(){}

    public static HomeEnvironmentState getInstance(){
        if(instance==null)
        {
            instance=new HomeEnvironmentState();
        }
        return instance;
    }

    /**
     * Updates an environmental state value and notifies relevant observers
     * @param key the state identifier
     * @param value the new state value
     */
    public void updateState(String key,Object value)
    {
        Object oldValue=stateValues.get(key);
        stateValues.put(key,value);

        if(!Objects.equals(oldValue,value)){
            notifyObservers(key,value);
        }
    }

    /**
     * Notifies all observers interested in a specific state
     * @param key the state that changed
     * @param value the new state value
     */
    private void notifyObservers(String key,Object value){
        if(observers.containsKey(key)){
            for(EnvironmentObserver observer: observers.get(key))
            {
                observer.onEnvironmentChange(key,value);
            }

        }
    }

    /**
     * Gets the current value of a state
     * @param key the state identifier
     * @return the current value or null if not set
     */
    public Object getState(String key){
        return stateValues.get(key);
    }

    /**
     * Register an observer for a specific state
     * @param key the state to observe
     * @param observer the observer to be notified
     */
    public void registerObserver(String key,EnvironmentObserver observer){
        observers.computeIfAbsent(key, k -> new ArrayList<>()).add(observer);
    }

    /**
     * Unregister an observer for a specific state
     * @param key the state being observed
     * @param observer the observer to remove
     */
    public void unregisterObserver(String key, EnvironmentObserver observer){
        if(observers.containsKey(key)){
            observers.get(key).remove(observer);
            if(observers.get(key).isEmpty()){
                observers.remove(key);
            }
        }
    }

    /**
     * Reset the state (mainly for testing purposes)
     */
    public void reset() {
        stateValues.clear();
        observers.clear();
    }
}
