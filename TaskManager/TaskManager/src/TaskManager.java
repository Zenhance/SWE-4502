public class TaskManager{
    private CommandHistory history=new CommandHistory();
    private Command command;
    public boolean done=false;
    public void setCommand(Command command){
        this.command=command;
    }
    public void execution(){
        command.execute();
        done=true;
        history.push(command);
    }
    private void undo(){
        if(history.isEmpty()){
            return;
        }
        Command command=history.pop();
        if(command!=null){

        }
    }
    public boolean getDone(){

        return done;
    }
}