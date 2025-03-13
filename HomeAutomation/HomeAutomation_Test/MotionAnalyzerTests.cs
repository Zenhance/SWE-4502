using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HomeAutomation;
using System.IO;

namespace HomeAutomation_Test
{
    [TestClass]
    public class MotionAnalyzerTests
    {
        private MotionAnalyzer _motionAnalyzer;

        [TestInitialize]
        public void Setup()
        {
            _motionAnalyzer = new MotionAnalyzer();
        }

        [TestMethod]
        public void TestLogMotion_SingleEntry()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionAnalyzer.LogMotion("Living Room");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Logged motion at Living Room on");
        }

        [TestMethod]
        public void TestLogMotion_MultipleEntries()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionAnalyzer.LogMotion("Kitchen");
            _motionAnalyzer.LogMotion("Garage");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Logged motion at Kitchen on");
            StringAssert.Contains(actualOutput, "Logged motion at Garage on");
        }

        [TestMethod]
        public void TestAnalyzePatterns_NoData()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionAnalyzer.AnalyzePatterns();

            string actualOutput = writer.ToString();
            Assert.AreEqual("No motion data available for analysis.\r\n", actualOutput);
        }

        [TestMethod]
        public void TestAnalyzePatterns_WithData()
        {
            _motionAnalyzer.LogMotion("Bedroom");
            _motionAnalyzer.LogMotion("Bedroom");
            _motionAnalyzer.LogMotion("Hallway");

            var writer = new StringWriter();
            Console.SetOut(writer);

            _motionAnalyzer.AnalyzePatterns();

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Motion Analysis Report:");
            StringAssert.Contains(actualOutput, "Location: Bedroom, Motion occurrences: 2");
            StringAssert.Contains(actualOutput, "Location: Hallway, Motion occurrences: 1");
        }
    }
}
