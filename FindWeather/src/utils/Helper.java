package utils;

import models.WeatherData;

public class Helper {
    // ANSI escape codes for colors and styles
    private final String RESET = "\u001B[0m";
    private final String GREEN = "\u001B[32m";
    private final String BLUE = "\u001B[34m";
    private final String YELLOW = "\u001B[33m";
    private final String CYAN = "\u001B[36m";
    private final String BOLD = "\u001B[1m";

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printHeader() {
        System.out.println(BOLD + GREEN + "======================================" + RESET);
        System.out.println(BOLD + GREEN + "========== Find Weather ==========" + RESET);
        System.out.println(GREEN + "======================================" + RESET);
    }

    public void printMenu() {
        System.out.println(BOLD + GREEN + "========== Main Menu ==========" + RESET);
        System.out.println(CYAN + "1. Get Weather Data" + RESET);
        System.out.println(CYAN + "2. Reset Cache" + RESET);
        System.out.println(CYAN + "3. Exit" + RESET);
        System.out.println(GREEN + "===============================" + RESET);
    }

    public void printWeatherMenu() {
        System.out.println(BOLD + BLUE + "===== Weather Options =====" + RESET);
        System.out.println(CYAN + "1. By IP Address" + RESET);
        System.out.println(CYAN + "2. By City Name" + RESET);
        System.out.println(BLUE + "===========================" + RESET);
    }

    public void printSuccess(String message) {
        System.out.println(BOLD + GREEN + "Success: " + RESET + message);
    }

    public void printError(String message) {
        System.out.println(BOLD + GREEN + "Error: " + RESET + message);
    }

    public int getOption() {
        System.out.print(BOLD + "Enter option: " + RESET);
        return Integer.parseInt(System.console().readLine());
    }

    public String getCityName() {
        System.out.print(BOLD + "Enter city name: " + RESET);
        return System.console().readLine();
    }

    public void displayData(WeatherData data) {
        System.out.println("\n");

        System.out.println(
                GREEN + BOLD + "Requested data for " + CYAN + "{{" + data.getLocation() + "}}" + GREEN + " -->>"
                        + RESET);
        System.out.println(YELLOW + "-----------------------------------------------------------------" + RESET);

        System.out.println(BOLD + BLUE + "Temperature: " + RESET + CYAN + data.getTemperature() + "°C" + RESET);
        System.out.println(BOLD + BLUE + "Conditions: " + RESET + CYAN + data.getConditions() + RESET);
        System.out.println(BOLD + BLUE + "Source: " + RESET + CYAN + data.getSource() + RESET);

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String readableDate = sdf.format(new java.util.Date(data.getTimestamp()));
        System.out.println(BOLD + BLUE + "Timestamp: " + RESET + CYAN + readableDate + RESET);

        System.out.println(YELLOW + "-----------------------------------------------------------------" + RESET);

        System.out.println("\n");
    }
}
