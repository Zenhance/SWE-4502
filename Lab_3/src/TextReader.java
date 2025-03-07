import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class TextReader {

    // Method to read the contents of a text file from the given path
    public static String readFromTextFile(String path) {
        try {
            // Convert the string path to a Path object
            Path filePath = Paths.get(path);

            // Read all bytes from the file and convert to a String
            return new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            // Handle the exception if the file can't be read
            e.printStackTrace();
            return "Error: Could not read the file.";
        }
    }

    public static void main(String[] args) {
        // Example usage
        String filePath = "example.txt";  // Replace with your file path
        String fileContent = readFromTextFile(filePath);
        System.out.println(fileContent);
    }
}

