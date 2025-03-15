package org.example;

import java.util.ArrayList;
import java.util.List;

public class History {
    private TextEditor editor;
    public List<EditorMemento> usage;
    private int idx;

    public History(TextEditor editor){
        if (editor==null){
            throw new IllegalArgumentException("Editor cannot be null");
        }
        this.editor= editor;
        this.usage= new ArrayList<>();
        this.idx= -1;
    }
    public void backup(){

    }
}
