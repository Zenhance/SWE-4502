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
    public class RemoteControllerTests
    {
        private RemoteController _remoteController;

        [TestInitialize]
        public void Setup()
        {
            _remoteController = new RemoteController();
        }

        [TestMethod]
        public void TestDisplayCurrentState()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.DisplayCurrentState();

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Current Home State:");
            StringAssert.Contains(actualOutput, "Lights: ON");
            StringAssert.Contains(actualOutput, "Thermostat: 22°C");
            StringAssert.Contains(actualOutput, "Motion detected: No");
            StringAssert.Contains(actualOutput, "Power consumption: 350W");
        }

        [TestMethod]
        public void TestGenerateNotifications()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.GenerateNotifications("Test Alert!");

            string actualOutput = writer.ToString();
            Assert.AreEqual("Notification: Test Alert!\r\n", actualOutput);
        }

        [TestMethod]
        public void TestControlSystem_TurnOnLights()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.ControlSystem("turn on the lights");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Executing system command: turn on the lights");
            StringAssert.Contains(actualOutput, "Lights turned on remotely.");
        }

        [TestMethod]
        public void TestControlSystem_TurnOffLights()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.ControlSystem("turn off the lights");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Executing system command: turn off the lights");
            StringAssert.Contains(actualOutput, "Lights turned off remotely.");
        }

        [TestMethod]
        public void TestControlSystem_SetThermostat()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.ControlSystem("set thermostat to 20 degrees");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Executing system command: set thermostat to 20 degrees");
            StringAssert.Contains(actualOutput, "Thermostat set to 20°C remotely.");
        }

        [TestMethod]
        public void TestControlSystem_UnknownCommand()
        {
            var writer = new StringWriter();
            Console.SetOut(writer);

            _remoteController.ControlSystem("open the garage");

            string actualOutput = writer.ToString();
            StringAssert.Contains(actualOutput, "Executing system command: open the garage");
            StringAssert.Contains(actualOutput, "Unknown command.");
        }
    }
}
