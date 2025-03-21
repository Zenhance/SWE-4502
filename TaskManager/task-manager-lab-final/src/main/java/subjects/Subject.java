package subjects;

import commands.Command;
import observers.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Command command);
    void notifyObserversUndo(Command command);
}
