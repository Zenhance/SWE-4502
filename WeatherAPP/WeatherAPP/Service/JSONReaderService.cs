using System.Text.Json;

namespace WeatherAPP.Service;

public class JSONReaderService
{
    public JsonDocument ReadJSON(string path)
    {
        using (StreamReader sr = new StreamReader(path))
        {
            string json = sr.ReadToEnd();
            return JsonDocument.Parse(json);
        }
    }
}