public class EnergyObserver implements Observer {
    public double currentPowerUsage;
    public String lastRoom;
    public double totalUsage = 0;
    public int count = 0;
    public double averageUsage = 0;

    @Override
    public void update(String message) {
        String[] parts = message.split(",");

        if (parts.length != 2) {
            System.err.println("Invalid message format");
            return;
        }

        try {
            currentPowerUsage = Double.parseDouble(parts[0].trim());
            this.lastRoom = parts[1].trim();


            totalUsage += currentPowerUsage;
            count++;
            averageUsage = totalUsage / count;

            System.out.println("Current Power Usage in " + lastRoom + ": " + currentPowerUsage + "W");

            detectUnusualConsumption(currentPowerUsage);

        } catch (NumberFormatException e) {
            System.err.println("Failed to parse power usage value: " + parts[0]);
        }
    }

    // We make method to detect unusual consumption patterns (high or low)
    public void detectUnusualConsumption(double currentUsage) {
        if (currentUsage > averageUsage * 2) {
            System.out.println("Unusual high consumption detected in " + lastRoom);
        } else if (currentUsage < averageUsage / 2) {
            System.out.println("Unusual low consumption detected in " + lastRoom);
        }
    }

    public double getAverageUsage() {
        return averageUsage;
    }

    public int getCount() {
        return count;
    }

    public double getTotalUsage() {
        return totalUsage;
    }
}
