// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SimpleMediator mediator = new SimpleMediator();

        TimeWidget timeWidget = new TimeWidget(mediator);
        WaqtWidget waqtWidget = new WaqtWidget(mediator);
        PrayerTimeWidget prayerWidget = new PrayerTimeWidget(mediator);
        CurrentWaqtWidget currentWaqtWidget = new CurrentWaqtWidget(mediator);
        NextPrayerWidget nextPrayerWidget = new NextPrayerWidget(mediator);

        mediator.setTimeWidget(timeWidget);
        mediator.setWaqtWidget(waqtWidget);
        mediator.setPrayerTimeWidget(prayerWidget);
        mediator.setCurrentWaqtWidget(currentWaqtWidget);
        mediator.setNextPrayerWidget(nextPrayerWidget);

        // Setting Initial Values
        timeWidget.updateTime("12:30");
        waqtWidget.setWaqt("Zuhr", "12:45");
        prayerWidget.setPrayerTime("Asr", "15:30");

        // Update Time to Trigger Notification
        timeWidget.updateTime("13:00");

    }
}