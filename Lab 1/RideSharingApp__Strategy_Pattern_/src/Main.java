import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RideSharingApp app = new RideSharingApp();

        try {
            app.start();
        } catch (IOException e) {
            System.out.println("An error occurred while starting the application: " + e.getMessage());
        }
    }
}
