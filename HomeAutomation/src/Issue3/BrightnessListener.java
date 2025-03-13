package Issue3;

import Issue1.IComponent;

public class BrightnessListener implements IComponent {

    private int lastBrightness;

    @Override
    public void onStateChange(String key, Object newValue) {
        if ("brightness".equals(key) && newValue instanceof Integer) {
            this.lastBrightness = (Integer) newValue;
        }
    }

    public int getLastBrightness() {
        return lastBrightness;
    }

}
