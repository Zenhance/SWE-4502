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


    


}
