package behaviours;

import java.util.concurrent.CompletableFuture;

public interface IweatherService {
    CompletableFuture<String> getWeatherData() throws Exception;
}
