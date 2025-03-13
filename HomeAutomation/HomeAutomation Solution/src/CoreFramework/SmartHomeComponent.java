package CoreFramework;

/**
 * Base class for all smart home components
 */
public abstract class SmartHomeComponent implements EnvironmentObserver{

    protected final HomeEnvironmentState environmentState;

    protected final String componentId;

    protected SmartHomeComponent(String componentId){
        this.componentId=componentId;
        environmentState=HomeEnvironmentState.getInstance();
    }

    /**
     * Initialize the component and register for relevant state changes
     */
    public abstract void initialize();

    /**
     * Shutdown the component and unregister observers
     */
    public abstract void shutdown();
}
