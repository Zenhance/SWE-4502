public class SimpleMediator implements Mediator
{
    public TimeWidget timeWidget;
    public WaqtWidget waqtWidget;
    public PrayerTimeWidget prayerTimeWidget;
    public CurrentWaqtWidget currentWaqtWidget;
    public NextPrayerWidget nextPrayerWidget;

    public void setTimeWidget(TimeWidget timeWidget)
    {
        this.timeWidget=timeWidget;
    }
    public void setWaqtWidget(WaqtWidget waqtWidget) {
        this.waqtWidget = waqtWidget;
    }

    public void setPrayerTimeWidget(PrayerTimeWidget prayerTimeWidget) {
        this.prayerTimeWidget = prayerTimeWidget;
    }

    public void setCurrentWaqtWidget(CurrentWaqtWidget currentWaqtWidget) {
        this.currentWaqtWidget = currentWaqtWidget;
    }

    public void setNextPrayerWidget(NextPrayerWidget nextPrayerWidget) {
        this.nextPrayerWidget = nextPrayerWidget;
    }

    @Override
    public void notify(String event)
    {
        if(event.equals("TimeUpdated"))
        {
            updateCurrentWaqt();
            updateNextPrayer();
        }
        else if (event.equals("WaqtUpdated"))
        {
            updateCurrentWaqt();
        }
        else if (event.equals("PrayerTimeUpdated"))
        {
            updateNextPrayer();
        }
    }

    public void updateCurrentWaqt()
    {
        String currenttime=timeWidget.getCurrentTime();
        String waqtTime= waqtWidget.getWaqtTime();

        if(currenttime!=null && waqtTime !=null && currenttime.compareTo(waqtTime) >= 0)
        {
            currentWaqtWidget.updateCurrentWaqt(waqtWidget.getWaqtName());
        }

    }

    public void updateNextPrayer()
    {
        String currentTime = timeWidget.getCurrentTime();
        String prayerTime = prayerTimeWidget.getPrayerTime();

        if(currentTime!=null && prayerTime !=null && currentTime.compareTo(prayerTime) < 0)
        {
            nextPrayerWidget.updateNextPrayer(prayerTimeWidget.getPrayerName());
        }
    }
}
