public class Main {
    public static void main(String[] args) {

            TextEditor editor = new TextEditor();
            History history = new History(editor);


            editor.setContent("Hello World!");
            editor.setPosition(5);
            editor.addSelection("World");
            editor.displayState();

            history.Backup();

            editor.setContent("Hello nafisa#!");
            editor.setPosition(7);
            editor.displayState();
            history.Backup();

            editor.ClearState();
            editor.displayState();




            history.Undo();
            editor.displayState();






    }
}

