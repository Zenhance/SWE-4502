public class Application {
    String clipboard;
    History history;
    Command cmd;
    Editor editor;

    public void execute(Command c){
        history.push(c);
        c.execute();
    }

    public void setUndoCommand(){
        UndoRedoCommand undo= new UndoRedoCommand(this, editor, "undo" );
        execute(undo);
    }

    public void setRedoCommand(){
        UndoRedoCommand redo= new UndoRedoCommand(this, editor, "redo" );
        execute(redo);
    }

}
