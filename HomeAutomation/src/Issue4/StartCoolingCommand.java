package Issue4;

import Issue1.StateManager;

public class StartCoolingCommand implements HVACCommand{

    private final StateManager stateManager;

    public StartCoolingCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    public void execute() {


        System.out.println("Command executed: Starting cooling system");

        stateManager.updateState(HVACController.MODE_KEY, HVACController.MODE_COOLING);
    }

}
