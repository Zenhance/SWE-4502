public class TestComponent implements IComponent {

    private String lastUpdatedKey;
    private Object lastUpdatedValue;

    @Override
    public void onStateChange(String key, Object newValue) {
        lastUpdatedKey = key;
        lastUpdatedValue = newValue;
    }

    public String getLastUpdatedKey() {
        return lastUpdatedKey;
    }

    public Object getLastUpdatedValue() {
        return lastUpdatedValue;
    }
}
