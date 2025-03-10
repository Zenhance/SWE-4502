public interface EnvironmentObserver {
    /**
     * Called when an observed state changes
     * @param key the state identifier that changed
     * @param newValue the new value of the state
     */

    void onEnvironmentChange(String key, Object newValue);
}
