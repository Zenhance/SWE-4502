import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EditorMemento {
    private String content;
    private int cursorPosition;
    private List<String> selections;

    // Default constructor for Jackson
    public EditorMemento() {}

    @JsonCreator
    public EditorMemento(@JsonProperty("content") String content,
                         @JsonProperty("cursorPosition") int cursorPosition,
                         @JsonProperty("selections") List<String> selections) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.selections = selections;
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getSelections() {
        return selections;
    }
}
