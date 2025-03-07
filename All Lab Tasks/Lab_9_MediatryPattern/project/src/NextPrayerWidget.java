public class NextPrayerWidget extends WidgetComponent
{
    private String nextPrayer;

    public NextPrayerWidget(Mediator mediator) {
        super(mediator);
    }

    public void updateNextPrayer(String prayer) {
        this.nextPrayer = prayer;
        System.out.println("Next Prayer Updated: " + nextPrayer);
    }

}
