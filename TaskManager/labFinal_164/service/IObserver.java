package labFinal_164.service;

import labFinal_164.command.ICommand;

public interface IObserver {
    void update(ICommand command);

}
