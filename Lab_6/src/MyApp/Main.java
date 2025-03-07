package MyApp;

import ThirdPartyLibrary.TheThirtPartyNotificator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        TheThirtPartyNotificator thirtPartyNotificator = new TheThirtPartyNotificator();

        String message = "Expecto Patronum";

        List<INotify> NotificatorList = new ArrayList<>();

        NotificatorList.add(new EmailNotification("tahsin@gmail.com")) ;
        NotificatorList.add(new SMSNotification("01645534121"));
        NotificatorList.add(new ThirdPartyNotificationAdapter(true, 90.101, 24.37, thirtPartyNotificator));



        for(INotify notificator : NotificatorList){
            notificator.sendNotification(message);
        }


    }

}
