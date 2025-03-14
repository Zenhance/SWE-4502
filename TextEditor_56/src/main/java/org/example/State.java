package org.example;

public class State {
    private String text;
    private int cursorPosition_X;
    private int cursorPosition_Y;

    public State(String text, int cursorPosition_X, int cursorPosition_Y){
        this.text = text;
        this.cursorPosition_X = cursorPosition_X;
        this.cursorPosition_Y = cursorPosition_Y;

    }

    public State getState(State state){
        return state;

    }
    public  String getText(){
        return this.text;
    }
    public int getCursorPosition_X(){
        return this.cursorPosition_X;
    }
    public int getCursorPosition_Y(){
        return this.cursorPosition_Y;
    }
}
