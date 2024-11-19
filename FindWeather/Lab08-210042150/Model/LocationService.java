package Model;

import Interfaces.ILocationService;

import java.io.IOException;

public class LocationService implements ILocationService {
    private static final String IPSTACK_API_KEY = "4a075c3610c3cba539c3fd2aca4d76ab";
    private String latitude;
    private String longitude;
}
