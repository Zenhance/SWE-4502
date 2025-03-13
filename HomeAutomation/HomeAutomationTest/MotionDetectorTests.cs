using HomeAutomation.Core;
using HomeAutomation.Components;
using System;
using Xunit;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{
    public class MotionDetectorTests
    {
        [Fact]
        public void OnStateChanged_SetsMotionDetectedTrue_WhenMotionDetected()
        {
            var detector = new MotionDetector();
            var state = new EnvironmentalState { MotionDetected = true };

            detector.OnStateChanged(state);

            Assert.True(detector.MotionDetected);
            Assert.NotEqual(default(DateTime), detector.LastMotionTime);
            Assert.Equal("Hallway", detector.LastLocation);
        }

        [Fact]
        public void OnStateChanged_SetsMotionDetectedFalse_WhenNoMotion()
        {
            var detector = new MotionDetector();
            var state = new EnvironmentalState { MotionDetected = false };

            detector.OnStateChanged(state);

            Assert.False(detector.MotionDetected);
        }
    }
}
