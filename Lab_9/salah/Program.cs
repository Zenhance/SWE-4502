using salah.Mediator;
using salah.Widgets;
using TimeZone = salah.Widgets.TimeZone;

class Program
{
    public static void Main()
    {
        WidgetMediator mediator = new WidgetMediator();

        IWidget _CurrentTime = new CurrentTime(mediator);
        IWidget _CurrentWaqt = new CurrentWaqt(mediator);
        IWidget _Location = new Location(mediator);
        IWidget _NextPrayer = new NextPrayer(mediator);
        IWidget _PrayerTimeSetting = new PrayerTimeSetting(mediator);
        IWidget _PrayerTimeTable = new PrayerTimeTable(mediator);
        IWidget _TimeZone = new TimeZone(mediator);
        IWidget _WaqtTimeTable = new WaqtTimeTable(mediator);
        
        mediator.SetRegistry(_CurrentTime, _CurrentWaqt, _Location, _NextPrayer, _PrayerTimeSetting, _PrayerTimeTable, _TimeZone, _WaqtTimeTable);
        
        _TimeZone.update();
    }
}