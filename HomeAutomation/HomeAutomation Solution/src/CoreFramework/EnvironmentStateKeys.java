package CoreFramework;

/**
 * Constants for state keys to ensure consistency
 */
public class EnvironmentStateKeys {
    // Motion detection keys
    public static final String MOTION_DETECTED = "motion.detected";
    public static final String MOTION_LOCATION = "motion.location";
    public static final String MOTION_TIMESTAMP = "motion.timestamp";

    // Light management keys
    public static final String AMBIENT_LIGHT_LEVEL = "light.ambient";
    public static final String LIGHT_SCENE = "light.scene";
    public static final String ROOM_OCCUPIED = "room.occupied";

    // Temperature keys
    public static final String CURRENT_TEMPERATURE = "temp.current";
    public static final String TARGET_TEMPERATURE = "temp.target";
    public static final String HVAC_STATUS = "hvac.status";

    // Energy consumption keys
    public static final String POWER_USAGE = "power.usage";
    public static final String POWER_ANOMALY = "power.anomaly";

    // Voice command keys
    public static final String VOICE_COMMAND = "voice.command";
    public static final String VOICE_COMMAND_PROCESSED = "voice.processed";

    // Remote access keys
    public static final String REMOTE_CONTROL_COMMAND = "remote.command";
    public static final String NOTIFICATION_EVENT = "notification.event";
}
