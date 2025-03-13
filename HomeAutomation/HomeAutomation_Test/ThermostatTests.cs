using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HomeAutomation;
using System.IO;

namespace HomeAutomation_Test
{
    [TestClass]
    public class ThermostatTests
    {
        private Thermostat _thermostat;
        private StringWriter _writer;

        [TestInitialize]
        public void Setup()
        {
            _thermostat = new Thermostat();
            _writer = new StringWriter();
            Console.SetOut(_writer);
        }

        [TestMethod]
        public void TestSetTargetTemperature()
        {
            _thermostat.SetTargetTemperature(22.5);
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Target temperature set to 22.5°C.");
        }

        [TestMethod]
        public void TestUpdateCurrentTemperature()
        {
            _thermostat.UpdateCurrentTemperature(21.0);
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Current temperature updated to 21°C.");
        }

        [TestMethod]
        public void TestControlTemperature_HeatingOn()
        {
            _thermostat.SetTargetTemperature(22.0);
            _thermostat.UpdateCurrentTemperature(21.0);
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Heating ON.");
        }

        [TestMethod]
        public void TestControlTemperature_CoolingOn()
        {
            _thermostat.SetTargetTemperature(22.0);
            _thermostat.UpdateCurrentTemperature(23.0);
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "Cooling ON.");
        }

        [TestMethod]
        public void TestControlTemperature_HVACIdle()
        {
            _thermostat.SetTargetTemperature(22.0);
            _thermostat.UpdateCurrentTemperature(22.3);
            string actualOutput = _writer.ToString();
            StringAssert.Contains(actualOutput, "HVAC system is idle.");
        }
    }
}
