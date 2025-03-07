public class RideType {
    private String type;    // Carpool/Luxury/Bike
    private String category;    //shared/Default
    private double baseFare;
    private double distanceRate;
    private double timeRate;
    private int capacity;

    public RideType(String type, String category, double baseFare, double distanceRate, double timeRate, int capacity) {
        this.type = type;
        this.category = category;
        this.baseFare = baseFare;
        this.distanceRate = distanceRate;
        this.timeRate = timeRate;
        this.capacity = capacity;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
    public String getCategory() {
        return category;
    }

    public double getDistanceRate() {
        return distanceRate;
    }

    public double getTimeRate() {
        return timeRate;
    }
}
