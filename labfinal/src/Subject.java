public interface Subject {
    void registerObserver(IObserver o);
    void removeObserver(IObserver o);

    void notifyObservers(Command command);
}