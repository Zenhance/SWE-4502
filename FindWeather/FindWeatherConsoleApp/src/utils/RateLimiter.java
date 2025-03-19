package utils;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private final ConcurrentHashMap<String, Instant> lastRequestTime;
    private static final int COOLDOWN_SECONDS=30;

    public RateLimiter() {
        this.lastRequestTime = new ConcurrentHashMap<>();
    }
    public boolean canMakeRequest(String provider)
    {
        Instant lastRequest=lastRequestTime.get(provider);
        if(lastRequest==null)
        {
            return true;
        }
        return Instant.now().isAfter(lastRequest.plusSeconds(COOLDOWN_SECONDS));
    }
    public void recordRequest(String provider)
    {
        lastRequestTime.put(provider,Instant.now());
    }

    public long getRemainingCooldownSeconds(String provider)
    {
        Instant lastRequest=lastRequestTime.get(provider);
        if(lastRequest==null)
        {
            return 0;
        }
        Instant nextAvailable=lastRequest.plusSeconds(COOLDOWN_SECONDS);
        long remainingSeconds=Instant.now().until(nextAvailable,java.time.temporal.ChronoUnit.SECONDS);
        return Math.max(0,remainingSeconds);
    }

}
