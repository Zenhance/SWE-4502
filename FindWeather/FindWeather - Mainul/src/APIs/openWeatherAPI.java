package APIs;

import org.json.JSONObject;

class openWeatherAPI {
    private String api_key;
    private String base_url;
    private JSONObject allInfo;
    public openWeatherAPI(){
        api_key = "e3dfd49f7917fe082f153b64f7ab41b9";
        base_url = "https://api.openweathermap.org/data/2.5/weather";
    }
    private void fetchData(String location){

    }
}
