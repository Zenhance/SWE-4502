public class LightObserver implements Observer {
    private int changedLightLevel;
    private String scene;
    private String lastRoom;

    @Override
    public void update(String message) {

        String[] parts = message.split(",");

        // Ensure message is in correct format
        if (parts.length != 3) {
            System.err.println("Invalid message format");
            return;
        }

        int lightLevel = Integer.parseInt(parts[0]);
        boolean roomOccupied = Boolean.parseBoolean(parts[1]);
        this.lastRoom = parts[2];

        // We arw adjusting light level based on room occupancy and light level
        if (!roomOccupied) {
            changedLightLevel = 0;
            scene = "Off";
        } else {
            if (lightLevel < 30) {
                changedLightLevel = 70;
                scene = "Reading";
            } else if (lightLevel >= 30 && lightLevel <= 70) {
                changedLightLevel = 60;
                scene = "Normal";
            } else {
                changedLightLevel = 30;
                scene = "Movie";
            }
        }


        System.out.println("Lighting Adjusted: Scene - " + scene + ", changedLight Level - " + changedLightLevel + ", Last Room - " + lastRoom);
    }

    public int getChangedLightLevel() {
        return changedLightLevel;
    }

    public String getScene() {
        return scene;
    }

    public String getLastRoom() {
        return lastRoom;
    }
}
