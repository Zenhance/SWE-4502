package Manager;

import Application.Driver;

public class DriverManager {

    public static int driverIDCounter = 0;
    public static Driver AssignDriver(){
        System.out.println("Driver Found! Requesting Driver...");
        driverIDCounter++;
        return new Driver(driverIDCounter, "John Doe", "1234", "mohakhali", 4.5, true);
    }
}
