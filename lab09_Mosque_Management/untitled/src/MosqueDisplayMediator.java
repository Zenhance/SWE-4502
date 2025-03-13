import java.util.Map;
import java.time.LocalTime;

class MosqueDisplayMediator implements DisplayMediator {
    private CurrentTimeWidget currentTimeWidget;
    private WaqtTimeTablesWidget waqtTimeTablesWidget;
    private PrayerTimeTableWidget prayerTimeTableWidget;
    private CurrentWaqtWidget currentWaqtWidget;
    private NextPrayerWidget nextPrayerWidget;

    @Override
    public void setComponent(Component component) {
        if (component instanceof CurrentTimeWidget) {
            currentTimeWidget = (CurrentTimeWidget) component;
        } else if (component instanceof WaqtTimeTablesWidget) {
            waqtTimeTablesWidget = (WaqtTimeTablesWidget) component;
        } else if (component instanceof PrayerTimeTableWidget) {
            prayerTimeTableWidget = (PrayerTimeTableWidget) component;
        } else if (component instanceof CurrentWaqtWidget) {
            currentWaqtWidget = (CurrentWaqtWidget) component;
        } else if (component instanceof NextPrayerWidget) {
            nextPrayerWidget = (NextPrayerWidget) component;
        }
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof CurrentTimeWidget && event.equals("timeUpdated")) {
            currentWaqtWidget.updateWaqt(currentTimeWidget.getCurrentTime(), waqtTimeTablesWidget.getWaqtTimes());
            nextPrayerWidget.updateNextPrayer(currentTimeWidget.getCurrentTime(), prayerTimeTableWidget.getPrayerTimes());
        } else if (sender instanceof WaqtTimeTablesWidget && event.equals("waqtUpdated")) {
            currentWaqtWidget.updateWaqt(currentTimeWidget.getCurrentTime(), waqtTimeTablesWidget.getWaqtTimes());
        } else if (sender instanceof PrayerTimeTableWidget && event.equals("prayerUpdated")) {
            nextPrayerWidget.updateNextPrayer(currentTimeWidget.getCurrentTime(), prayerTimeTableWidget.getPrayerTimes());
        }
    }
}
