import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TextEditor implements Serializable
{
    private static final long serialVersionUID = 1L;
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
        if(selection !=null && !selection.isEmpty()) {
            selections.add(selection);
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
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));
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
