package ThirdPartyLibrary;

public class TheThirtPartyNotificator {

    public TheThirtPartyNotificator(){

    }

    public void send(double latitude, double longitude, String message, boolean isConfidential){
        System.out.println("\nSent By Third Party Notificator at " + latitude + " / " + longitude +
                "\nconfidentiality : " + isConfidential +
                "\nMessage : " + message);
    }

}
