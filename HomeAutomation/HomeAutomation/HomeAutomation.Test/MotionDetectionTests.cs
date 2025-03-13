using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Test
{
    public class MotionDetectionTests
    {
        [Fact]
        public void TestDetectMotion()
        {
            var coreSystem = new CoreSystem();
            var motionDetection = new MotionDetection(coreSystem);
            motionDetection.DetectMotion("Living Room", "12:00 PM");
            Assert.Equal("Living Room at 12:00 PM", coreSystem.GetState("motion"));
        }
    }
}
