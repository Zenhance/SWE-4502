import utils.ConsoleHelper;
import datamodels.WeatherData;
import datamodels.LocationData;
import facadeservice.FacadeService;

public class Main {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        FacadeService facadeService = new FacadeService();

        consoleHelper.clearScreen();
        consoleHelper.printHeader();

        while (true) {
            consoleHelper.printMenu();
            int option = consoleHelper.getOption();

            switch (option) {
                case 1 -> {
                    consoleHelper.printWeatherMenu();
                    int weatherOption = consoleHelper.getOption();

                    try {
                        switch (weatherOption) {
                            case 1 -> {
                                String city = consoleHelper.getCityName();
                                WeatherData weatherData = facadeService.getWeatherByCity(city);
                                consoleHelper.displayWeatherData(weatherData);
                            }
                            case 2 -> {
                                WeatherData weatherData = facadeService.getWeatherByIP();
                                consoleHelper.displayWeatherData(weatherData);
                            }
                            default -> consoleHelper.printError("Invalid weather option.");
                        }
                    } catch (Exception e) {
                        consoleHelper.printError("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        LocationData locationData = facadeService.getCurrentLocation();
                        consoleHelper.displayLocationData(locationData);
                    } catch (Exception e) {
                        consoleHelper.printError("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    consoleHelper.printSuccess("Exiting application. Goodbye!");
                    System.exit(0);
                }
                default -> consoleHelper.printError("Invalid menu option.");
            }
        }
    }
}
