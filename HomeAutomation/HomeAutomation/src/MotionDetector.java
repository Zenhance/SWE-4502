public class MotionDetector implements Observer
{
    private boolean motionDetected;

    @Override
    public void update(EnvironmentState state)
    {
        this.motionDetected = state.isMotionDetected();
        if (motionDetected)
        {
            activate();
        }
        else
        {
            deactivate();
        }
    }

    @Override
    public void update(SystemState state)
    {
        this.motionDetected = state.motionDetected;
        if (motionDetected)
        {
            activate();
        }
        else
        {
            deactivate();
        }
    }

    public void activate()
    {
        System.out.println("Motion detected: Activating response.");
    }

    public void deactivate()
    {
        System.out.println("No motion detected: Deactivating response.");
    }

    public boolean isMotionDetected()
    {
        return motionDetected;
    }
}
