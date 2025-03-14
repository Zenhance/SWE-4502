import java.io.Serial;
import java.io.Serializable;

public record EditorMemento(String content, int cursorPosition, String selection) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // Constructor to initialize the state

}
