package labFinal_164.service;

import labFinal_164.command.ICommand;

public interface ISubject {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers(ICommand command);


}
