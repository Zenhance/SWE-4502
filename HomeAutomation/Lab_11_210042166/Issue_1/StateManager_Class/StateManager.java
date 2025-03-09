package Lab_11_210042166.Issue_1.StateManager_Class;

import Lab_11_210042166.Issue_1.Interface.Component;
import Lab_11_210042166.Issue_1.Storage_Class.EnvironmentState;

import java.util.ArrayList;
import java.util.List;

public class StateManager {
    private final List<Component> components=new ArrayList<>();
    private EnvironmentState currentState;

    public void registerComponent(Component component){
        components.add(component);
    }

    public void unregisterComponent(Component component){
        components.remove(component);
    }
    private void notifyComponents(){
        for(Component component:components){
            component.update(currentState);
        }
    }
    public void updateState(EnvironmentState newState){
        this.currentState=newState;
        notifyComponents();
    }

}
