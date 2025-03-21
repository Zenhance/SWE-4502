package subjects;

public interface Subject {
    void addObserver();
    void removeObserver();
    void notifyObserver();
}
