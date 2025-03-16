using HomeAutomation;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation_Tests
{
    [TestClass]
    public class MotionSensorTests
    {
        private MotionSensor _motionSensor;

        [TestInitialize]
        public void Setup()
        {
            _motionSensor = new MotionSensor();
        }

        [TestMethod]
        public void TestDetectMotion()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionSensor.DetectMotion("Garage");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Motion detected in Garage at");

            Assert.IsTrue(_motionSensor.IsMotionDetected());
        }

        [TestMethod]
        public void TestIsMotionDetected_InitiallyFalse()
        {
            Assert.IsFalse(_motionSensor.IsMotionDetected());
        }

        [TestMethod]
        public void TestReset()
        {
            _motionSensor.DetectMotion("Living Room");
            Assert.IsTrue(_motionSensor.IsMotionDetected());

            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionSensor.Reset();

            string actualOutput = writer.ToString();
            Assert.AreEqual("Motion sensor reset.\r\n", actualOutput);
            Assert.IsFalse(_motionSensor.IsMotionDetected());
        }
    }
}
