import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateManager {

    private final EvironmentalState state = new EvironmentalState();

    private final Map<String, List<IComponent>> components =new HashMap<>();

    public void registerComponent(String key, IComponent component) {

        if (!components.containsKey(key)) {
            components.put(key, new ArrayList<>());
        }

        components.get(key).add(component);


    }




    public void removeComponent(String key, IComponent component){
        if(components.containsKey(key)){
            components.get(key).remove(component);
        }
    }


    public void notifyComponents(String key, Object newValue){
        if(components.containsKey(key)){
            for(IComponent component: components.get(key)){
                component.onStateChange(key, newValue);
            }
        }
    }

    public void updateState(String key, Object value){
        state.updateState(key, value);
        notifyComponents(key, value);
    }


    public Object getState(String key){
        return state.getState(key);
    }

    public EvironmentalState getState() {
        return state;
    }
}
