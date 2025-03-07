package IpServices;

import Models.LocationData;

public class testIpAddress {
    public static void main(String[] args) {
        IpStackService ipStackService = new IpStackService();
        
        System.out.println("Hello Ip!");
        // Get current IP address
        String ipAddress = ipStackService.getCurrentIPAddress();
        System.out.println("Current IP Address: " + ipAddress);

        // Get location details using IP address
        if (ipAddress != null) {
            LocationData location = ipStackService.getLocationByIP(ipAddress);
            if (location != null) {
                System.out.println("Location Details: " + location.city + ", " + location.country);
            }
        }
    }
}
