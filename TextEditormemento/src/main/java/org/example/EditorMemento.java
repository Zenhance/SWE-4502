package org.example;

import java.util.ArrayList;
import java.util.List;

public class EditorMemento
{
    private String content;
    private int cursorPosition;
    private  List<String> selections;

    public EditorMemento(String content, int cursorPosition, List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = List.copyOf(selections);
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return selections;
    }
    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, selections);
    }
    public void restoreFromMemento(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }


}
