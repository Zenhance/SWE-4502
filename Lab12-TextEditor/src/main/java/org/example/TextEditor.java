package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextEditor {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor(String content, int cursorPosition, List<String> selections){
        this.content="";
        this.cursorPosition= 0;
        this.selections= new ArrayList<>();
    }

    public void setContent(String content){
        this.content = Objects.requireNonNullElse(content, "");
        cursorPosition= this.content.length()-1;
    }
    public void setCursorPosition(int position){
        if (position >=0 && position <= content.length()-1) {
            cursorPosition = position;
        } else{
            throw new IllegalArgumentException("Position must be between 0 and content length");
        }
    }
    public void addSelections(String selection){
        if (selection==null){
            throw new IllegalArgumentException("Selection cannot be empty");
        }
        selections.add(selection);
    }
    public void clearSelections(){
        selections.clear();
    }
    public void displayState(){
        System.out.println("Content: "+content);
        System.out.println("Cursor Position: "+cursorPosition);
        System.out.print("Selections: ");
        if (selections==null){
            System.out.print("---No Selection---");
        } else {
            System.out.print(selections);
        }
        System.out.println("----------------------------------");
    }


//    public EditorMemento createMemento(){
//        return new EditorMemento(content, cursorPosition, selections);
//    }
//    public void RestoreFromMemento(EditorMemento memento){
//        if (memento == null) {
//            throw new IllegalArgumentException("Memento cannot be null");
//        }
//        content= memento.getContent();
//        cursorPosition= memento.getCursorPosition();
//        selections= memento.getSelections();
//        displayState();
//    }
}
