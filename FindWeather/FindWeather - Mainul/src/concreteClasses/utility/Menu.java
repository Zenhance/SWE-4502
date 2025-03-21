package concreteClasses.utility;

import APIs.IPgettingAPI;
import adapters.IPStackAPIAdapter;

import java.util.Scanner;

public class Menu {
    public void printMainMenu(){
        System.out.println("Select Location Method");
        System.out.println("1. IP" +
                "\n2. City" +
                "\n3. Exit");
    }
    public String getcityName(int input){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        switch (input){
            case 1:
                IPgettingAPI ip = new IPgettingAPI();
                System.out.println("Please Submit IP adress. { Your IP Adress is : }" + ip.getIP());
                String IP  = myObj.nextLine();
                IPStackAPIAdapter ip2city= new IPStackAPIAdapter(IP);
                return ip2city.getCityName();
            case 2:
                System.out.println("Please Enter city name.");
                String cityName  = myObj.nextLine();
                return cityName;
            default:
                return "";
        }


    }
}
