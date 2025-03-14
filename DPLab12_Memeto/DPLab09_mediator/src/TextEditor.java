public class TextEditor {
    private String content;
    private int cursorPosition;
    private String selection;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.selection = "";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCursorPosition(int position) {
        this.cursorPosition = position;
    }

    public void addSelection(String selection) {
        this.selection = selection;
    }

    public void clearSelections() {
        this.selection = "";
    }

    public void displayState() {
        System.out.println("Content: " + content);
        System.out.println("Cursor Position: " + cursorPosition);
        System.out.println("Selection: " + selection);
    }


}
