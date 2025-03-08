package com.findweather;

import java.util.HashMap;

public class RateLimiter {
    private static final HashMap<String, Long> rateLimits = new HashMap<>();
    private static final long COOLDOWN_TIME = 30 * 1000; // 30 seconds

    public static boolean isRateLimited(String provider) {
        if (rateLimits.containsKey(provider)) {
            return System.currentTimeMillis() - rateLimits.get(provider) < COOLDOWN_TIME;
        }
        return false;
    }

    public static void markRequest(String provider) {
        rateLimits.put(provider, System.currentTimeMillis());
    }
}
