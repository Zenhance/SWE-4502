package Issue5;


public class EnergyStats {
    private final double averagePower;
    private final double peakPower;
    private final double cumulativeEnergy;

    public EnergyStats(double averagePower, double peakPower, double cumulativeEnergy) {
        this.averagePower = averagePower;
        this.peakPower = peakPower;
        this.cumulativeEnergy = cumulativeEnergy;
    }

    public double getAveragePower() { return averagePower; }
    public double getPeakPower() { return peakPower; }
    public double getCumulativeEnergy() { return cumulativeEnergy; }
}
