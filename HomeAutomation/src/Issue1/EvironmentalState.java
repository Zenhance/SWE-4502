package Issue1;

import java.util.HashMap;
import java.util.Map;

public class EvironmentalState {
    private final Map<String, Object> stateInfo=new HashMap<>();

    public void updateState(String key, Object value){
        stateInfo.put(key, value);
    }

    public Object getState(String key){
        return stateInfo.get(key);
    }


}
