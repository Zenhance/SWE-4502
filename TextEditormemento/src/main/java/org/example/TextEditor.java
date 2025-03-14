package org.example;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    /*
    **Description:**
    Implement the core TextEditor class with basic text editing capabilities:
- Add private fields for content, cursor position, and selections
- Implement constructor
- Create methods:
  - SetContent(string content)
  - SetCursorPosition(int position)
  - AddSelection(string selection)
  - ClearSelections()
  - DisplayState()
     */
        private String content;
        private int cursorPosition;
        private List<String> selections;

        public TextEditor() {
            this.content = "";
            this.cursorPosition = 0;
            this.selections = new ArrayList<>();
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCursorPosition(int position)
        {

            this.cursorPosition = position;
        }

        public void addSelection(String selection) {
            if (selection != null && !selection.isEmpty()) {
                this.selections.add(selection);
            }
        }

        public void clearSelections() {
            this.selections.clear();
        }

        public void displayState() {
            System.out.println("Content: " + content);
            System.out.println("Cursor Position: " + cursorPosition);
            System.out.println("Selections: " + selections);
        }

}
