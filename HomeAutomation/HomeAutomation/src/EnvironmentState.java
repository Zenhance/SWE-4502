public class EnvironmentState {
    private Map<String, Object> stateData = new HashMap<>();

    public void updateState(String key, Object value) {
        stateData.put(key, value);
    }

    public Object getState(String key) {
        return stateData.get(key);
    }
}