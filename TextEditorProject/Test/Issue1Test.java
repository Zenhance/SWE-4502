import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.Arrays;
import static org.junit.Assert.*;

public class Issue1Test {

    private History history;
    private static final String FILE_PATH = "C:\\Study\\CODES\\SWE-4502\\test.txt"; // Your file path

    @Before
    public void setUp() {
        // Create a new History instance before each test
        history = new History();
    }

    @Test
    public void saveToFile_ShouldSaveMementos() {
        // Prepare test data
        EditorMemento memento1 = new EditorMemento("Hello World", 0, Arrays.asList("Hello"));
        EditorMemento memento2 = new EditorMemento("Goodbye World", 5, Arrays.asList("Goodbye"));

        // Add mementos to the history
        history.addMemento(memento1);
        history.addMemento(memento2);

        // Save history to file
        history.saveToFile(FILE_PATH);

        // Verify that the file exists
        File file = new File(FILE_PATH);
        assertTrue("File should be created", file.exists());

    }



}
