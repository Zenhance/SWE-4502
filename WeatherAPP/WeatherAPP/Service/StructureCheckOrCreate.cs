using System;
using System.IO;
using WeatherAPP.Environment;

namespace WeatherAPP.Service
{
    public class StructureCheckOrCreate
    {
        private readonly string _root;
        private readonly string _location;
        private readonly string _weather;

        public StructureCheckOrCreate()
        {
            _root = WEnvironment.GetRootDirPath();
            _location = WEnvironment.GetLocationFilePath();
            _weather = WEnvironment.GetWeatherFilePath();
        }

        public void Execute()
        {
            try
            {
                if (!Directory.Exists(_root))
                {
                    Directory.CreateDirectory(_root);
                }

                if (!File.Exists(_location))
                {
                    File.WriteAllText(_location, "[]");
                }

                if (!File.Exists(_weather))
                {
                    File.WriteAllText(_weather, "[]");
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                throw;
            }
        }
    }
}