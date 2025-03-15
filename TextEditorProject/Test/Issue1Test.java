import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Issue1Test {

    private TextEditor editor;
    private History history;
    private final String TEST_FILE = "E:\\SWE-4502\\TextEditorProject\\test.txt";

    @Before
    public void setUp() {
        editor = new TextEditor();
        history = new History(editor);
    }



    @Test
    public void SetContent_ShouldUpdateContent() {
        // Arrange
        String expectedContent = "Test content";

        // Act
        editor.setContent(expectedContent);

        // Assert
        EditorMemento memento = editor.createMemento();
        assertEquals(expectedContent, memento.getContent());
    }

    @Test
    public void SaveAndLoadState_ShouldPreserveEditorState() {

        String expectedContent = "Test content for saving";
        int expectedPosition = 5;
        List<String> expectedSelections = Arrays.asList("selection1", "selection2");

        editor.setContent(expectedContent);
        editor.setCursorPosition(expectedPosition);
        for (String selection : expectedSelections) {
            editor.addSelection(selection);
        }

        history.Backup();


        history.SaveToFile(TEST_FILE);

        History newHistory = new History(new TextEditor());
        newHistory.LoadFromFile(TEST_FILE);


        EditorMemento loadedMemento = newHistory.getCurrentEditorMemento();

        assertEquals(expectedContent, loadedMemento.getContent());
        assertEquals(expectedPosition, loadedMemento.getCursorPosition());
        assertEquals(expectedSelections.size(), loadedMemento.getSelections().size());
        for (String selection : expectedSelections) {
            assertTrue(loadedMemento.getSelections().contains(selection));
        }
    }





}








