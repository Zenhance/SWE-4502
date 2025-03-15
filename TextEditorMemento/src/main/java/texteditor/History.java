package main.java.texteditor;

import java.util.Stack;

public class History {
    private final Stack<EditorMemento> historyStack = new Stack<>();
    private final TextEditor editor;

    public History(TextEditor editor) {
        this.editor = editor;
    }

    public void backup() {
        EditorMemento memento = editor.createMemento();
        historyStack.push(memento);
        System.out.println("Backup created.");
    }

    public void undo() {
        if (historyStack.isEmpty()) {
            System.out.println("No previous state to restore.");
            return;
        }
        EditorMemento memento = historyStack.pop();
        editor.restoreFromMemento(memento);
        System.out.println("Undo successful.");
    }
}
