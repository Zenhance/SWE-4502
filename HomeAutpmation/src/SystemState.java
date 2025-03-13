public class SystemState {
    private SystemStateType stateType;
    private String stateDescription;

    public SystemState(SystemStateType stateType, String stateDescription) {
        this.stateType = stateType;
        this.stateDescription = stateDescription;
    }
    public SystemState() {

    }
    public SystemStateType getStateType() {
        return stateType;
    }

    public void setStateType(SystemStateType stateType) {
        this.stateType = stateType;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

}
