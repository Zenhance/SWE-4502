package Commands;
import CoreFramework.HomeEnvironment;

public class SetLightSceneCommand implements Command{
    private final String scene;

    public SetLightSceneCommand(String scene) {
        this.scene = scene;
    }

    @Override
    public void execute(){
        HomeEnvironment.getInstance().setState("lightScene", scene);

    }

}
