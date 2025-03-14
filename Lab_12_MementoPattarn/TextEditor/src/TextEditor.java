import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TextEditor implements Serializable
{
    private static final long serialVersionUID = 1L;//The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found, then an InvalidClassException is thrown.
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selections= new ArrayList<>();
    }

    public void setContent(String content) {
        if(content == null) {
            this.content = "";
        } else {
            this.content = content;
        }
    }

    public void setCursorPosition(int position)
    {
        if(position < 0) {
            this.cursorPosition = 0;
        } else if(position > content.length()) {
            this.cursorPosition = content.length();
        } else {
            this.cursorPosition = position;
        }
    }

    public void addSelection(String selection) {
        if(selection !=null && !selection.isEmpty())//if selection is not null and not empty
        {
            selections.add(selection);//add selection to the selections list;
        }

    }

    public void clearSelections() {
        selections.clear();
    }

    public void displayState() {
        System.out.println("Text Editor State");
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections (" + selections.size() + "):");
        for (int i = 0; i < selections.size(); i++) {
            System.out.println("  " + (i + 1) + ": " + selections.get(i));
        }
        System.out.println("-------------------------");
    }

    public EditorMemento createMemento() {
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));//return a new EditorMemento object with the current content, cursorPosition, and selections
    }

    public void restoreFromMemento(EditorMemento memento)
    {
        if(memento!=null) {
            this.content = memento.getContent();
            this.cursorPosition = memento.getCursorPosition();
            this.selections = new ArrayList<>(memento.getSelections());
        }

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

}
