package Lab_final_210042166.Task_Management_System.Manage_Command;

import Lab_final_210042166.Task_Management_System.Interface.Command;

import java.util.Stack;

public class CommandManager {
    private Stack<Command>executeCommands=new Stack<>();
    private Stack<Command>undoneCommands=new Stack<>();

    public void executeCommand(Command command)
    {
        command.execute();
        executeCommands.push(command);
        undoneCommands.clear();
    }

    public void undo(){
        if(!executeCommands.isEmpty())
        {
            Command command=executeCommands.pop();
            command.undo();
            undoneCommands.push(command);
        }
    }
    public void redo()
    {
        if(!undoneCommands.isEmpty()){
            Command command=undoneCommands.pop();
            command.execute();
            executeCommands.push(command);
        }
    }
}
