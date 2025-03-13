import java.util.Map;
import java.time.LocalTime;

public class MosqueDisplaySystem {
    public static void main(String[] args) {

        MosqueDisplayMediator mediator = new MosqueDisplayMediator();


        CurrentTimeWidget currentTimeWidget = new CurrentTimeWidget();
        WaqtTimeTablesWidget waqtTimeTablesWidget = new WaqtTimeTablesWidget();
        PrayerTimeTableWidget prayerTimeTableWidget = new PrayerTimeTableWidget();
        CurrentWaqtWidget currentWaqtWidget = new CurrentWaqtWidget();
        NextPrayerWidget nextPrayerWidget = new NextPrayerWidget();


        currentTimeWidget.setMediator(mediator);
        waqtTimeTablesWidget.setMediator(mediator);
        prayerTimeTableWidget.setMediator(mediator);
        currentWaqtWidget.setMediator(mediator);
        nextPrayerWidget.setMediator(mediator);


        mediator.setComponent(currentTimeWidget);
        mediator.setComponent(waqtTimeTablesWidget);
        mediator.setComponent(prayerTimeTableWidget);
        mediator.setComponent(currentWaqtWidget);
        mediator.setComponent(nextPrayerWidget);


        currentTimeWidget.setCurrentTime(LocalTime.of(12, 30));
        waqtTimeTablesWidget.setWaqtTimes(Map.of("Fajr", LocalTime.of(5, 0), "Dhuhr", LocalTime.of(12, 0), "Asr", LocalTime.of(15, 30)));
        prayerTimeTableWidget.setPrayerTimes(Map.of("Fajr", LocalTime.of(5, 0), "Dhuhr", LocalTime.of(12, 30), "Asr", LocalTime.of(15, 45)));
    }
}