package main.commands;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> mainStack;
    private Stack<Command> historyStack;

    public CommandHistory() {
        this.mainStack = new Stack<>();
        this.historyStack = new Stack<>();
    }

    public void PushToMainStack(Command c){
        mainStack.push(c);
    }

    public void PushToHistoryStack(Command c){
        historyStack.push(c);
    }
    
    public void PopFromMainStack(){
        mainStack.pop();
    }
    
    public void PopFromHistoryStack(){
        historyStack.pop();
    }

    public void ClearHistoryStack(){
        historyStack.clear();
    }
}