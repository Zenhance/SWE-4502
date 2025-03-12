public class MotionObserver implements Observer {
    private String lastLocation;
    private String lastTime;

    @Override
    public void update(String message) {
        String[] parts = message.split(",");
        this.lastLocation = parts[0];
        this.lastTime = parts[1];
        System.out.println("Motion detected at: " + lastLocation + " at " + lastTime);
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public String getLastTime() {
        return lastTime;
    }
}
