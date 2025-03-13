using HomeAutomation.Motion;

namespace HomeAutomation.Light.Tests;

public class LightManagerTests
{
    [Fact()]
    public void UpdateTestLightState()
    {
        LightManager lightManager = new LightManager();
        LightState lightState = new LightState();
        var result = lightManager.Update(lightState);
        Assert.Equal(lightState.ToString(), result);
    }

    [Fact()]
    public void UpdateTestMotionState()
    {
        LightManager lightManager = new LightManager();
        MotionState motionState = new MotionState();
        var result = lightManager.Update(motionState);
        Assert.Equal(motionState.ToString(), result);
    }

    [Fact()]
    public void SetSceneTestReading()
    {
        LightManager lightManager = new LightManager();
        var result = lightManager.SetScene("Reading");
        Assert.Equal(10, result);
    }
    [Fact()]
    public void SetSceneTestMovie()
    {
        LightManager lightManager = new LightManager();
        var result = lightManager.SetScene("Movie");
        Assert.Equal(5, result);
    }

    [Fact()]
    public void SetSceneTestSleep()
    {
        LightManager lightManager = new LightManager();
        var result = lightManager.SetScene("Sleep");
        Assert.Equal(1, result);
    }

    [Fact()]
    public void SetSceneTestInvalidScene()
    {
        LightManager lightManager = new LightManager();
        Assert.Throws<KeyNotFoundException>(() => lightManager.SetScene("Invalid"));
    }
}