package utils;

import datamodels.WeatherData;
import datamodels.LocationData;

import java.util.Scanner;

public class ConsoleHelper {
    private final String RESET = "\u001B[0m";
    private final String GREEN = "\u001B[32m";
    private final String BLUE = "\u001B[34m";
    private final String YELLOW = "\u001B[33m";
    private final String CYAN = "\u001B[36m";
    private final String RED = "\u001B[31m";
    private final String BOLD = "\u001B[1m";

    private final Scanner scanner;

    public ConsoleHelper() {
        this.scanner = new Scanner(System.in);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printHeader() {
        System.out.println(BOLD + GREEN + "======================================" + RESET);
        System.out.println(BOLD + GREEN + "========== Weather Finder ==========" + RESET);
        System.out.println(GREEN + "======================================" + RESET);
    }

    public void printMenu() {
        System.out.println(BOLD + BLUE + "========== Main Menu ==========" + RESET);
        System.out.println(CYAN + "1. Get Weather Data" + RESET);
        System.out.println(CYAN + "2. Get Current Location" + RESET);
        System.out.println(CYAN + "3. Exit" + RESET);
        System.out.println(BLUE + "===============================" + RESET);
    }

    public void printWeatherMenu() {
        System.out.println(BOLD + GREEN + "===== Weather Options =====" + RESET);
        System.out.println(CYAN + "1. By City Name" + RESET);
        System.out.println(CYAN + "2. By IP Address" + RESET);
        System.out.println(GREEN + "===========================" + RESET);
    }

    public int getOption() {
        System.out.print(BOLD + "Enter option: " + RESET);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input! Please enter a number between 1 and 3." + RESET);
            }
        }
    }

    public String getCityName() {
        System.out.print(BOLD + "Enter city name: " + RESET);
        return scanner.nextLine();
    }

    public void printSuccess(String message) {
        System.out.println(BOLD + GREEN + "Success: " + RESET + message);
    }

    public void printError(String message) {
        System.out.println(BOLD + RED + "Error: " + RESET + message);
    }

    public void displayWeatherData(WeatherData data) {
        System.out.println("\n" + GREEN + BOLD + "Weather Details:" + RESET);
        System.out.println(YELLOW + "------------------------------------------------" + RESET);
        System.out.println(BLUE + "Location: " + RESET + CYAN + data.getLocation().getCity()+ ", " + data.getLocation().getCountry());
        System.out.println(BLUE + "Temperature: " + RESET + CYAN + data.getTemperature() + "°C");
        System.out.println(BLUE + "Conditions: " + RESET + CYAN + data.getWeatherConditions());
        System.out.println(BLUE + "Data Source: " + RESET + CYAN + data.getDataSource());
        System.out.println(YELLOW + "------------------------------------------------" + RESET);
        System.out.println("\n");
    }

    public void displayLocationData(LocationData data) {
        System.out.println("\n" + GREEN + BOLD + "Your Location:" + RESET);
        System.out.println(YELLOW + "------------------------------------------------" + RESET);
        System.out.println(BLUE + "City: " + RESET + CYAN + data.getCity());
        System.out.println(BLUE + "Region: " + RESET + CYAN + data.getLatitude()+ ", " + data.getLongitude());
        System.out.println(BLUE + "Country: " + RESET + CYAN + data.getCountry());
        System.out.println(YELLOW + "------------------------------------------------" + RESET);
        System.out.println("\n");
    }
}
