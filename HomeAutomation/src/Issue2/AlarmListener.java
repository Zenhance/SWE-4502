package Issue2;

import Issue1.IComponent;

public class AlarmListener implements IComponent {
    private AlarmEvent lastAlarm;

    @Override
    public void onStateChange(String key, Object newValue) {
        if ("alarm".equals(key) && newValue instanceof AlarmEvent) {
            this.lastAlarm = (AlarmEvent) newValue;
        }
    }

    public AlarmEvent getLastAlarm() {
        return lastAlarm;
    }
}