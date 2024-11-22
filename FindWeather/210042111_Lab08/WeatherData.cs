namespace _210042111_Lab08
{  public class WeatherData
    {       public string CityName { get; set; }
        public string WeatherCondition { get; set; }
        public double WeatherTemperature { get; set; }
        public string LocationInformation { get; set; }

        public WeatherData(string CityName, string WeatherCondition, double WeatherTemperature)
        {
            this.CityName = CityName;
            this.WeatherCondition = WeatherCondition;
            this.WeatherTemperature = WeatherTemperature;
        }

    }
}
