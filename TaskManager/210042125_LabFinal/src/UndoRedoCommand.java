public class UndoRedoCommand extends Command {

    String command;

    public UndoRedoCommand(Application app, Editor editor, String command) {
        super(app, editor);
        this.command = command;
    }

    @Override
    public void execute() {
        String s1= backup;
        backup= editor.text;

        if (command == "Undo") {
            editor.text = backup;
            saveBackup();
        }
        else{
            editor.text = s1;
            backup= s1;
        }
    }
}