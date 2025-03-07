import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


//Created for Tesing purposes
//        IPLocation ipLocation=new IPLocation();
//
//        Location location=ipLocation.get_Location_by_IP();
//        location.Display_Location_Info();
//
//        WeatherAPI weatherapi=new WeatherAPI();
//
//        weatherapi.Get_Weather(location);
//        Weather weather=weatherapi.Get_Weather(location);
//
//        weather.DisplayWeather();
//
//        GeoLocation geolocation=new GeoLocation();
//        Location location1=geolocation.get_Location_by_city("Tungi");
//
//        location1.Display_Location_Info();



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select location method: 1. By IP, 2. By City, 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 3)
            {
                break;
            }

            Location location = null;
            if (choice == 1) {
                location = IPLocation.get_Location_by_IP();
            } else if (choice == 2) {
                System.out.print("Enter city name: ");
                String city = scanner.nextLine();
                location = GeoLocation.get_Location_by_city(city);
            }

            if(location!= null){
                System.out.println("City: " + location.getCity() + " (Latitude, Longitude) => (" + location.getLatitude() + ", " + location.getLongitude()+")");

                Weather weather = WeatherAPI.Get_Weather(location);
                weather.DisplayWeather();
                System.out.println("________________________________________________________");
            }
        }
        scanner.close();





    }
}