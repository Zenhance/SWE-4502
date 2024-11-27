package adapters;

import APIs.IPStackAPI;
import org.json.JSONObject;

public class IPStackAPIAdapter {
    private IPStackAPI api;
    private JSONObject allinfo;
    public IPStackAPIAdapter(){
        api = new IPStackAPI("355dbc2e06a2a5956bc522f5a7d1ca21");
    }
    public String getCityName(){
        return allinfo.getString("city");
    }
}
//adapter