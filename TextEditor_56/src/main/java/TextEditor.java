
import org.example.State;



public class TextEditor {
    private String text;
    private  int cursorPosition_X;
    private  int cursorPosition_Y;
    State state;

    public TextEditor(String text, int cursorPosition_X, int cursorPosition_Y){
        this.text = text;
        this.cursorPosition_X = cursorPosition_X;
        this.cursorPosition_Y = cursorPosition_Y;
        this.state= new State(text, cursorPosition_X, cursorPosition_Y);
    }

    public String write(String text){
        this.text += text;
        return this.text;

    }
    public void moveCursor(int x, int y){
        this.cursorPosition_X = x;
        this.cursorPosition_Y = y;
    }
    public String getText(){
        return this.text;
    }
    public int getCursorPosition_X(){
        return this.cursorPosition_X;
    }
    public int getCursorPosition_Y(){
        return this.cursorPosition_Y;
    }

    public Memento save(){
        return new Memento(new State(text, cursorPosition_X, cursorPosition_Y));

    }

    public  void restore(Memento memento){
        State state = memento.getState();
        this.text = state.getText();
        this.cursorPosition_X = state.getCursorPosition_X();
        this.cursorPosition_Y = state.getCursorPosition_Y();




    }
}
