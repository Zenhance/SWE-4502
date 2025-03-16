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
    public class VoiceProcessorTests
    {
        private VoiceProcessor _voiceProcessor;
        private StringWriter _writer;

        [TestInitialize]
        public void Setup()
        {
            _voiceProcessor = new VoiceProcessor();
            _writer = new StringWriter();
            Console.SetOut(_writer);
        }

        [TestMethod]
        public void TestProcessCommand_TurnOnLights()
        {
            _voiceProcessor.ProcessCommand("Turn on the lights");
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Processing voice command: Turn on the lights");
            StringAssert.Contains(actualOutput, "Executing: Turning on the lights.");
        }

        [TestMethod]
        public void TestProcessCommand_TurnOffLights()
        {
            _voiceProcessor.ProcessCommand("Turn off the lights");
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Processing voice command: Turn off the lights");
            StringAssert.Contains(actualOutput, "Executing: Turning off the lights.");
        }

        [TestMethod]
        public void TestProcessCommand_SetThermostat()
        {
            _voiceProcessor.ProcessCommand("Set thermostat to 22 degrees");
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Processing voice command: Set thermostat to 22 degrees");
            StringAssert.Contains(actualOutput, "Executing: Setting thermostat to 22°C.");
        }

        [TestMethod]
        public void TestProcessCommand_UnknownCommand()
        {
            _voiceProcessor.ProcessCommand("Play some music");
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Processing voice command: Play some music");
            StringAssert.Contains(actualOutput, "Command not recognized.");
        }

        [TestMethod]
        public void TestGetLastCommand()
        {
            _voiceProcessor.ProcessCommand("Turn on the lights");
            string lastCommand = _voiceProcessor.GetLastCommand();
            Assert.AreEqual("Turn on the lights", lastCommand);
        }

        [TestMethod]
        public void TestGetLastCommand_NoCommandProcessed()
        {
            string lastCommand = _voiceProcessor.GetLastCommand();
            Assert.AreEqual("No command processed yet.", lastCommand);
        }

        [TestMethod]
        public void TestShowCommandHistory()
        {
            _voiceProcessor.ProcessCommand("Turn on the lights");
            _voiceProcessor.ProcessCommand("Set thermostat to 22 degrees");

            _voiceProcessor.ShowCommandHistory();
            string actualOutput = _writer.ToString();

            StringAssert.Contains(actualOutput, "Voice Command History:");
            StringAssert.Contains(actualOutput, "- Turn on the lights");
            StringAssert.Contains(actualOutput, "- Set thermostat to 22 degrees");
        }
    }
}
