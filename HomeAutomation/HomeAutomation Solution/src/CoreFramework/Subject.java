package CoreFramework;

public interface Subject {
    void registerObserver(String eventType, Observer observer);
    void removeObserver(String eventType, Observer observer);
    void notifyObservers(String eventType, Object value);
}
