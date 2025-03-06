import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherFacade weatherFacade = new WeatherFacade();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect location method:");
            System.out.println("1. By IP");
            System.out.println("2. By City");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Getting weather data by IP...");
                    weatherFacade.getWeatherByIP();
                    break;
                case "2":
                    System.out.print("Enter city name: ");
                    String city = scanner.nextLine();
                    weatherFacade.getWeatherByCity(city);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}