using Xunit;
using HomeAutomation.Components;
using HomeAutomation.Core_Model;

namespace TestProject1
{
    public class TestMotionDetectionTest
    {
        [Fact]
        public void Test_MotionDetection_NoMotion()
        {
            MotionDetection motionDetector = new MotionDetection();
            CentralState state = new CentralState { MotionDetected = false };

            motionDetector.Update(state);
            Assert.False(state.MotionDetected, "Motion should not be detected initially.");
        }
    }
}
