using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HomeAutomation;
using System.IO;

namespace HomeAutomation_Test
{
    [TestClass]
    public class EnergyMonitorTests
    {
        private EnergyMonitor _energyMonitor;

        [TestInitialize]
        public void Setup()
        {
            _energyMonitor = new EnergyMonitor();
        }

        [TestMethod]
        public void TestRecordPowerUsage()
        {
            // Arrange
            double watts = 100.0;

            // Act
            _energyMonitor.RecordPowerUsage(watts);

            // Assert
            double totalConsumption = _energyMonitor.GetTotalConsumption();
            Assert.AreEqual(watts, totalConsumption, "Power usage should be recorded correctly.");
        }

        [TestMethod]
        public void TestGetTotalConsumption_WithMultipleRecords()
        {
            // Arrange
            _energyMonitor.RecordPowerUsage(100.0);
            _energyMonitor.RecordPowerUsage(200.0);
            _energyMonitor.RecordPowerUsage(300.0);

            // Act
            double totalConsumption = _energyMonitor.GetTotalConsumption();

            // Assert
            Assert.AreEqual(600.0, totalConsumption, "Total consumption should be the sum of recorded values.");
        }

        [TestMethod]
        public void TestAnalyzeUsagePatterns_WithNoData()
        {
            // Arrange
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _energyMonitor.AnalyzeUsagePatterns();

            // Assert
            string expectedOutput = "No data available for analysis.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Console output should indicate no data available.");
        }

        [TestMethod]
        public void TestAnalyzeUsagePatterns_WithData()
        {
            // Arrange
            _energyMonitor.RecordPowerUsage(100.0);
            _energyMonitor.RecordPowerUsage(200.0);
            _energyMonitor.RecordPowerUsage(300.0);
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _energyMonitor.AnalyzeUsagePatterns();

            // Assert
            string output = writer.ToString();
            Assert.IsTrue(output.Contains("Average Power Usage"), "Output should contain average usage.");
            Assert.IsTrue(output.Contains("Peak Power Usage"), "Output should contain peak usage.");
        }
    }
}
