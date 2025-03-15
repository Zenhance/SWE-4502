package Issue4;

import Issue1.StateManager;

public class StartHeatingCommand implements HVACCommand{
    private final StateManager stateManager;

    public StartHeatingCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void execute() {

        System.out.println("Command executed: Starting heating system");

        stateManager.updateState(HVACController.MODE_KEY, HVACController.MODE_HEATING);
    }


}
