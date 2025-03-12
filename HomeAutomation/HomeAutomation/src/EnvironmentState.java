import java.util.HashMap;
import java.util.Map;

public class EnvironmentState {
    private final Map<String,Object>state=new HashMap<>();

    public void updateState(String key,Object value){
        state.put(key,value);
    }

    public Object getState(String key){
        return state.get(key);
    }
}
