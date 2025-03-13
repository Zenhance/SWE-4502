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

        [Fact]
        public void Test_MotionDetection_MotionDetected()
        {
            MotionDetection motionDetector = new MotionDetection();
            CentralState state = new CentralState { MotionDetected = true };

            motionDetector.Update(state);
            Assert.True(state.MotionDetected, "Motion should be detected correctly.");
        }

        [Fact]
        public void Test_MotionDetection_ToggleMotion()
        {
            MotionDetection motionDetector = new MotionDetection();
            CentralState state = new CentralState { MotionDetected = false };

            state.MotionDetected = true;
            motionDetector.Update(state);
            Assert.True(state.MotionDetected, "Motion state should toggle correctly.");
        }


    }
}
