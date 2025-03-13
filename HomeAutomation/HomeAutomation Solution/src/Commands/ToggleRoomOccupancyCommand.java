package Commands;

import CoreFramework.HomeEnvironment;

public class ToggleRoomOccupancyCommand implements Command{
    private final boolean occupied;
    public ToggleRoomOccupancyCommand(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public void execute(){
        HomeEnvironment.getInstance().setState("roomOccupancy", occupied);
    }
}
