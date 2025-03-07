public interface StateObserver {
    /**
     * This method is called whenever the environmental state changes.
     * @param state The new state of the environment
     */
    void onStateChange(State state);
}