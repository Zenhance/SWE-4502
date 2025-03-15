package Issue4;

import Issue1.StateManager;

public class StopHVACCommand implements HVACCommand{

    private final StateManager stateManager;

    public StopHVACCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void execute() {
        System.out.println("Command executed: Stopping HVAC system");
    }


}
