package core.model;


public class Measurement {
    public enum Units {
        CELSIUS,
        FAHRENHEIT,
        WATT,
        PERCENT,
        COUNT,
        BOOLEAN
    }

    private double value;
    private Units units;

    public Measurement(double value, Units units) {
        this.value = value;
        this.units = units;
    }

    public double getValue() {
        return value;
    }

    public Units getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "value=" + value +
                ", units=" + units +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Measurement that = (Measurement) obj;
        if (Double.compare(that.value, value) != 0) return false;
        return units == that.units;
    }
}

