package org.example;

import java.util.ArrayList;
import java.util.List;

public class EditorMemento {
//    private String content;
//    private int cursorPosition;
//    private List<String> selections;
//
//    // Constructor to initialize state
//    public EditorMemento() {
//        this.content = "";
//        this.cursorPosition = 0;
//        this.selections = new ArrayList<>();
//    }
//    public EditorMemento(String content, int cursorPosition, List<String> selections) {
//        this.content = content;
//        this.cursorPosition = cursorPosition;
//        this.selections = selections;
//    }

    public String getContent(){
        return content;
    }
    public int getCursorPosition(){
        return cursorPosition;
    }
    public List<String> getSelections(){
        return selections;
    }

}
