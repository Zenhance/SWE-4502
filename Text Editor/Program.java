package texteditor;

public class Program {
    public static void main(String[] args) {
        System.out.println("Text Editor Application");
        
        // Create a new text editor instance
        TextEditor editor = new TextEditor();
        
        // Create a history manager for undo operations
        History history = new History(editor);
        
        // Simple demonstration
        editor.setContent("Hello World");
        editor.setCursorPosition(5);
        editor.displayState();
        
        // Save state
        history.backup();
        
        // Change state
        editor.setContent("Modified Content");
        editor.displayState();
        
        // Restore previous state
        history.undo();
        editor.displayState();
    }
} 