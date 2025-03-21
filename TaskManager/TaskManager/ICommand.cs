using System;

public interface ICommand
{
	void execute();
	void Undo();
}
