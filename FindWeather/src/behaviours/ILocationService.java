package behaviours;

import java.util.concurrent.CompletableFuture;

import models.LocationData;

public interface ILocationService {
    CompletableFuture<LocationData> getLocationData() throws Exception;
}
