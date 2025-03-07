import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextWriter {

    // Method to write the text to a file
    public static void writeToTextFile(String text) {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            String timestamp = now.format(formatter);

            String filePath = "E:\\output"+timestamp+".txt";
            // Define the file path where the text will be written (on D drive)
            Path path = Paths.get(filePath);

            // Write the text to the file with UTF-8 encoding
            Files.write(path, text.getBytes(StandardCharsets.UTF_8));

            // Confirmation message
            System.out.println("Text has been written to: " + filePath);
        } catch (IOException e) {
            // Handle any exceptions
            e.printStackTrace();
        }
    }
}