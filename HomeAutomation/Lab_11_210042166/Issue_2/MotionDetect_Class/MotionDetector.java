package Lab_11_210042166.Issue_2.MotionDetect_Class;

import Lab_11_210042166.Project_Structure.Interface.Component;
import Lab_11_210042166.Project_Structure.StateManager_Class.StateManager;
import Lab_11_210042166.Project_Structure.Storage_Class.EnvironmentState;

import java.util.ArrayList;
import java.util.List;

public class MotionDetector implements Component {
    private List<String> motionLog = new ArrayList<>();
    private StateManager stateManager;

    public MotionDetector(StateManager stateManager) {
        this.stateManager = stateManager;
        this.stateManager.registerComponent(this);
    }

    @Override
    public void update(EnvironmentState state) {
        if (state.isMotionDetected()) {
            String timestamp = String.valueOf(System.currentTimeMillis());
            motionLog.add("Motion detected at: " + timestamp);
            System.out.println("Motion detected at: " + timestamp);
        }
    }

    public List<String> getMotionLog() {
        return motionLog;
    }
    public boolean hasSuspiciousActivity() {
        if (motionLog.size() > 5) {
            return true;
        }
        return false;
    }
}
