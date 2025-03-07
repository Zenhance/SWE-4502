import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StateManager stateManager = new StateManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHome Automation System");
            System.out.println("1. Update Temperature");
            System.out.println("2. Update Humidity");
            System.out.println("3. Toggle Lights");
            System.out.println("4. Toggle Security System");
            System.out.println("5. View Current State");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter temperature (°C): ");
                    double temperature = scanner.nextDouble();
                    stateManager.updateTemperature(temperature);
                    break;
                case 2:
                    System.out.print("Enter humidity (%): ");
                    double humidity = scanner.nextDouble();
                    stateManager.updateHumidity(humidity);
                    break;
                case 3:
                    boolean currentLightStatus = stateManager.getCurrentState().isLightStatus();
                    stateManager.updateLightStatus(!currentLightStatus);
                    System.out.println("Lights " + (!currentLightStatus ? "ON" : "OFF"));
                    break;
                case 4:
                    boolean currentSecurityStatus = stateManager.getCurrentState().isSecurityStatus();
                    stateManager.updateSecurityStatus(!currentSecurityStatus);
                    System.out.println("Security System " + (!currentSecurityStatus ? "ARMED" : "DISARMED"));
                    break;
                case 5:
                    System.out.println(stateManager.getCurrentState().toString());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}