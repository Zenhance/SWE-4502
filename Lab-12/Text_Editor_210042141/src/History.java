import java.util.Stack;
import java.io.*;

public class History
{
    private final TextEditor editor;
    private final Stack<EditorMemento> mementos;

    public History(TextEditor editor)
    {
        this.editor = editor;
        this.mementos = new Stack<>();
    }

    public void backup()
    {
        mementos.push(editor.createMemento());
    }

    public void undo()
    {
        if (!mementos.isEmpty())
        {
            editor.restoreFromMemento(mementos.pop());
        }
        else
        {
            System.out.println("No actions to undo.");
        }
    }

    public void restoreFrom()
    {

    }

    public void savetoFile(String filePath)
    {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            out.writeObject(mementos);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filePath)
    {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath)))
        {
            @SuppressWarnings("unchecked")
            Stack<EditorMemento> loadedMementos = (Stack<EditorMemento>) in.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
