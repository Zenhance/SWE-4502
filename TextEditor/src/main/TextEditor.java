package main;
import java.util.ArrayList;
import java.util.List;

//core editor class. manage the content, cursor position, and selections.
public class TextEditor {
    private StringBuilder content;
    private int cursorPosition;
    private List<String>selections;

    public TextEditor(){
        this.content = new StringBuilder();
        this.cursorPosition = 0;
        this.selections = new ArrayList<>();
    }

    public void setContent(String content){
        this.content=new StringBuilder(content);
        this.cursorPosition=content.length();
    }
    public void setCursorPosition(int position){
        if(position >= 0 && position <=content.length()){
            this.cursorPosition=position;
        }
        else{
            System.out.println("Invalid cursor position");

        }
    }

    public void addSelection (String selection){
        selections.add(selection);
    }
    public void clearSelections(){
        selections.clear();
    }
    public void displayState(){
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selections: " + selections);

    }
    public String getContent() {
        return content.toString();
    }
    public int getCursorPosition(){
        return cursorPosition;
    }
    public List<String> getSelections(){
        return new ArrayList<>(selections);
    }
    public void setState(String content,int cursorPosition,List<String> selections){
        this.content=new StringBuilder(content);
        this.cursorPosition=cursorPosition;
        this.selections=new ArrayList<>(selections);
    }
//to create and restore memento
    public EditorMemento createMemento(){
        return new EditorMemento(content.toString(),cursorPosition,selections);
    }

    public void restoreFromMemento(EditorMemento memento){
        setState(memento.getContent(), memento.getCursorPosition(),memento.getSelections());

    }

    private History history = new History(this);
    public void saveState() {
        history.save();
    }
    public void undoState(){
        history.undo();
    }

}
