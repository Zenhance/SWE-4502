package texteditor;

import java.io.IOException;

public interface ISerialization {

    void saveToFile(String filePath) throws IOException;
    void loadFromFile(String filePath) throws IOException;
}
