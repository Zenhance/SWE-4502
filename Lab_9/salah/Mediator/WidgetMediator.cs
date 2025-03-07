using salah.Widgets;

namespace salah.Mediator;

public class WidgetMediator
{
    private Dictionary<IWidget, List<IWidget>> WidgetRegistry;

    public WidgetMediator()
    {
        
    }

    public void SetRegistry(IWidget currentTime,
                            IWidget CurrentWaqt,
                            IWidget Location,
                            IWidget NextPrayer,
                            IWidget PrayerTimeSetting,
                            IWidget PrayerTimeTable,
                            IWidget TimeZone,
                            IWidget WaqtTimeTable)
    {
        WidgetRegistry = new Dictionary<IWidget, List<IWidget>>();
        
        List<IWidget> for_location = new List<IWidget>();
        for_location.Add(WaqtTimeTable);
        WidgetRegistry.Add(Location, for_location);

        List<IWidget> for_timezone = new List<IWidget>();
        for_timezone.Add(currentTime);
        for_timezone.Add(WaqtTimeTable);
        WidgetRegistry.Add(TimeZone, for_timezone);

        List<IWidget> for_prayerTimeSetting = new List<IWidget>();
        for_prayerTimeSetting.Add(PrayerTimeTable);
        WidgetRegistry.Add(PrayerTimeSetting, for_prayerTimeSetting);

        List<IWidget> for_currentTime = new List<IWidget>();
        for_currentTime.Add(CurrentWaqt);
        for_currentTime.Add(NextPrayer);
        WidgetRegistry.Add(currentTime, for_currentTime);

        List<IWidget> for_WaqtTimeTable = new List<IWidget>();
        for_WaqtTimeTable.Add(CurrentWaqt);
        WidgetRegistry.Add(WaqtTimeTable, for_WaqtTimeTable);

        List<IWidget> for_PrayerTimeTable = new List<IWidget>();
        for_PrayerTimeTable.Add(NextPrayer);
        WidgetRegistry.Add(PrayerTimeTable, for_PrayerTimeTable);
    }


    public void Notify(IWidget sender)
    {
        try
        {
            foreach (IWidget widgets in WidgetRegistry[sender])
            {
                widgets.update();
            }
        }
        catch(Exception ex)
        {
            
        }
        
    }

}