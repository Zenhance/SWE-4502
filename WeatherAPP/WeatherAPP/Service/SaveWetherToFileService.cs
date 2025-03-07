using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using WeatherAPP.Environment;
using WeatherAPP.Model;

namespace WeatherAPP.Service
{
    public class SaveWetherToFileService
    {
        private readonly string _wetherjsonpath;

        public SaveWetherToFileService()
        {
            _wetherjsonpath = WEnvironment.GetWeatherFilePath();
        }

        public void Execute(Wether weather)
        {
            string filePath = _wetherjsonpath;

            // List to hold weather data
            List<Wether> weatherList;

            // Check if the file exists
            if (File.Exists(filePath))
            {
                try
                {
                    // Read the existing JSON and deserialize into a list
                    string existingJson = File.ReadAllText(filePath);
                    weatherList = JsonSerializer.Deserialize<List<Wether>>(existingJson) ?? new List<Wether>();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error reading or deserializing existing JSON file: " + ex.Message);
                    throw;
                }
            }
            else
            {
                // Initialize a new list if the file doesn't exist
                weatherList = new List<Wether>();
            }

            // Append the new weather object
            weatherList.Add(weather);

            try
            {
                // Serialize the updated list and write it back to the file
                string updatedJson = JsonSerializer.Serialize(weatherList, new JsonSerializerOptions { WriteIndented = true });
                File.WriteAllText(filePath, updatedJson);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error writing updated JSON to file: " + ex.Message);
                throw;
            }
        }
    }
}