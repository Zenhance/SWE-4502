import java.util.ArrayList;
import java.util.List;

public class TextEditor
{
    private String content;
    private int cursorPosition;
    private List<String> selections;

    public TextEditor()
    {
        this.content = "";
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setCursorPosition(int position)
    {
        this.cursorPosition = position;
    }

    public void addSelection(String selection)
    {
        if (selection != null && !selection.isEmpty())
        {
            selections.add(selection);
        }
        else
        {
            System.out.println("Error! Selection cannot be null or empty.");
        }
    }

    public void clearSelections()
    {
        this.selections.clear();
    }

    public EditorMemento createMemento()
    {
        return new EditorMemento(content, cursorPosition, new ArrayList<>(selections));
    }

    public void restoreFromMemento(EditorMemento memento)
    {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.selections = new ArrayList<>(memento.getSelections());
    }

    // current state of the editor
    public void displayState()
    {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);
    }
}


