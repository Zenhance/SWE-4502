using HomeAutomation;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation_Test
{
    [TestClass]
    public class LightingControllerTests
    {
        private LightingController _lightingController;

        [TestInitialize]
        public void Setup()
        {
            _lightingController = new LightingController();
        }

        [TestMethod]
        public void TestTurnOn_LightsTurnedOn()
        {
            // Arrange
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.TurnOn();

            // Assert
            string expectedOutput = "Lights turned ON.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Lights should turn ON and the correct message should be printed.");
        }

        [TestMethod]
        public void TestTurnOff_LightsTurnedOff()
        {
            // Arrange
            _lightingController.TurnOn(); 
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.TurnOff();

            // Assert
            string expectedOutput = "Lights turned OFF.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Lights should turn OFF and the correct message should be printed.");
        }

        [TestMethod]
        public void TestAdjustBrightness_WhenLightsAreOn()
        {
            // Arrange
            _lightingController.TurnOn(); 
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.AdjustBrightness(50);

            // Assert
            string expectedOutput = "Brightness set to 50%.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Brightness should be adjusted correctly when lights are ON.");
        }

        [TestMethod]
        public void TestAdjustBrightness_WhenLightsAreOff()
        {
            // Arrange
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.AdjustBrightness(50);

            // Assert
            string expectedOutput = "Cannot adjust brightness. Lights are OFF.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Adjusting brightness should not work when lights are OFF.");
        }

        [TestMethod]
        public void TestAdjustBrightness_WhenSettingBeyondMaxLimit()
        {
            // Arrange
            _lightingController.TurnOn(); 
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.AdjustBrightness(150); 

            // Assert
            string expectedOutput = "Brightness set to 100%.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Brightness should not exceed 100%.");
        }

        [TestMethod]
        public void TestAdjustBrightness_WhenSettingBelowMinLimit()
        {
            // Arrange
            _lightingController.TurnOn(); 
            var writer = new StringWriter();
            Console.SetOut(writer); 

            // Act
            _lightingController.AdjustBrightness(-10); 

            // Assert
            string expectedOutput = "Brightness set to 0%.\r\n";
            string actualOutput = writer.ToString();
            Assert.AreEqual(expectedOutput, actualOutput, "Brightness should not go below 0%.");
        }
    }
}
