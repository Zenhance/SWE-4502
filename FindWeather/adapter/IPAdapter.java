package adapter;
import api.IPStackService;
import models.Location;

public class IPAdapter {
    private final IPStackService ipService;
    public IPAdapter() {
        this.ipService = new IPStackService();
    }
    public Location getLocationByIP() throws Exception {
        return ipService.getLocationByIP();
    }
}
