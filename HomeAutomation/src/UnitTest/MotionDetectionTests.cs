using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class MotionDetectionTests
    {
        [Fact]
        public void TestDetectMotion()
        {
            var coreComponent = new CoreComponent();
            var motionDetection = new MotionDetection(coreComponent);
            motionDetection.DetectMotion("Living Room", "11:00 PM");
            Assert.Equal("Living Room at 11:00 PM", coreComponent.GetState("motion"));
        }
    }
}
