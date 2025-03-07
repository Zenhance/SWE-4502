public class PrayerTimeWidget extends WidgetComponent
{
    private String prayerName;
    private String prayerTime;

    public PrayerTimeWidget(Mediator mediator) {
        super(mediator);
    }

    public void setPrayerTime(String name, String time) {
        this.prayerName = name;
        this.prayerTime = time;
        System.out.println("Prayer Time Updated: " + prayerName + " -> " + prayerTime);
        mediator.notify("PrayerTimeUpdated");
    }

    public String getPrayerTime() {
        return prayerTime;
    }

    public String getPrayerName() {
        return prayerName;
    }

}
