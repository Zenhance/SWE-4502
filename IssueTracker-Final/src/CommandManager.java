import java.util.Stack;

public class CommandManager {

    public Stack <Command> executedCommands = new Stack<>();
    public Stack <Command> undoneCommands = new Stack<>();


    


    public void executeCommand(Command command){
        command.execute();
        executedCommands.push(command);
    }

    public void undoCommand(){
        if(executedCommands.isEmpty()){
            System.out.println("No commands to undo");
        }else{
            Command command=executedCommands.pop();
            command.undo();
            undoneCommands.push(command);
        }
    }

    public void redoCommand(){
        if(undoneCommands.isEmpty()){
            System.out.println("No commands to redo");
        }else{
            Command command=undoneCommands.pop();
            command.execute();
            executedCommands.push(command);
        }

        
    }
}
