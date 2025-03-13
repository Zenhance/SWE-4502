using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var mediator = new MosqueDisplayMediator();

            var currentTime = new CurrentTimeWidget();
            var waqtTimeTables = new WaqtTimeTablesWidget();
            var prayerTimeTable = new PrayerTimeTableWidget();
            var currentWaqt = new CurrentWaqtWidget();
            var nextPrayer = new NextPrayerWidget();

            mediator.CurrentTime = currentTime;
            mediator.WaqtTimeTables = waqtTimeTables;
            mediator.PrayerTimeTable = prayerTimeTable;
            mediator.CurrentWaqt = currentWaqt;
            mediator.NextPrayer = nextPrayer;

            currentTime.SetMediator(mediator);
            waqtTimeTables.SetMediator(mediator);
            prayerTimeTable.SetMediator(mediator);
            currentWaqt.SetMediator(mediator);
            nextPrayer.SetMediator(mediator);

            Console.WriteLine("Updating Location and TimeZone:");
            mediator.Notify(null, "LocationChanged");

            Console.WriteLine("\nUpdating Prayer Time Settings:");
            mediator.Notify(null, "PrayerTimeSettingsChanged");

            Console.WriteLine("\nUpdating Current Time:");
            mediator.Notify(null, "CurrentTimeUpdated");

            Console.ReadLine();
        }
    }
}
