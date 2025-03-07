package MyApp;

import ThirdPartyLibrary.TheThirtPartyNotificator;

import java.time.chrono.ThaiBuddhistEra;

public class ThirdPartyNotificationAdapter implements INotify{
    public boolean isConfidential;
    public double latitude;
    public double longitude;

    TheThirtPartyNotificator thirtPartyNotificator;

    public ThirdPartyNotificationAdapter(boolean isConfidential, double latitude, double longitude, TheThirtPartyNotificator thirtPartyNotificator){
        this.isConfidential = isConfidential;
        this.latitude = latitude;
        this.longitude = longitude;
        this. thirtPartyNotificator = new TheThirtPartyNotificator();
    }

    @Override
    public void sendNotification(String message){
        TheThirtPartyNotificator thirtPartyNotificator = new TheThirtPartyNotificator();
        thirtPartyNotificator.send(latitude, longitude, message, isConfidential);
    }
}
