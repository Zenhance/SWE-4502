using System.Text.Json;

namespace FindWeather.Location;

public class IpstackLocationAdapter : ILocationApi
{
    private readonly HttpClient _httpClient;
    private const string BaseUrlForIp = "https://api.ipify.org";
    private const string ApiKey = "5aafdde732421bb8d92f63128a79d9ee";

    public IpstackLocationAdapter()
    {
        _httpClient = new HttpClient();
    }

    

    public async Task<(double Latitude, double Longitude, string City)> GetLocation()
    {
        var ipAddress = await GetPublicIPAddress();
        var response = _httpClient.GetStringAsync(
            $"http://api.ipstack.com/{ipAddress}?access_key={ApiKey}"
        ).Result;

        var json = JsonDocument.Parse(response);
        
        var latitude = json.RootElement.GetProperty("latitude").GetDouble();
        var longitude = json.RootElement.GetProperty("longitude").GetDouble();
        var city = json.RootElement.GetProperty("city").GetString();
        
        return (latitude, longitude, city!);
    }
    
    private async Task<string> GetPublicIPAddress()
    {
        try
        {
            var response = await _httpClient.GetAsync(BaseUrlForIp);
            response.EnsureSuccessStatusCode();

            var ipAddress = await response.Content.ReadAsStringAsync();
            return ipAddress;
        }
        catch (HttpRequestException ex)
        {
            throw new Exception("Network error occurred. Check your internet connection.", ex);
        }
        catch (TaskCanceledException ex) when (!ex.CancellationToken.IsCancellationRequested)
        {
            throw new Exception("The request timed out. The server may be slow or unreachable.", ex);
        }
        catch (Exception ex)
        {
            throw new Exception("An unexpected error occurred.", ex);
        }
    }
}