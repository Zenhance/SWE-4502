package behaviours;

import java.util.concurrent.CompletableFuture;

public interface ILocationService {
    CompletableFuture<String> getLocationData() throws Exception;
}
