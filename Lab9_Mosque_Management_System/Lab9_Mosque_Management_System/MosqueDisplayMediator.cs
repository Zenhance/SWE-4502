using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public class MosqueDisplayMediator : IMediator
    {
        public CurrentTimeWidget CurrentTime { get; set; }
        public WaqtTimeTablesWidget WaqtTimeTables { get; set; }
        public PrayerTimeTableWidget PrayerTimeTable { get; set; }
        public CurrentWaqtWidget CurrentWaqt { get; set; }
        public NextPrayerWidget NextPrayer { get; set; }

        public void Notify(object sender, string eventDetails)
        {
            switch (eventDetails)
            {
                case "LocationChanged":
                case "TimeZoneChanged":
                    WaqtTimeTables.Update();
                    CurrentTime.Update();
                    break;
                case "PrayerTimeSettingsChanged":
                    PrayerTimeTable.Update();
                    NextPrayer.Update();
                    break;
                case "CurrentTimeUpdated":
                    CurrentWaqt.Update();
                    NextPrayer.Update();
                    break;
                case "WaqtTimeUpdated":
                    CurrentWaqt.Update();
                    break;
            }
        }
    }
}
