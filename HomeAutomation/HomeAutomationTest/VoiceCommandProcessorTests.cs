using HomeAutomation.Components;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{
    public class VoiceCommandProcessorTests
    {
        [Fact]
        public void ProcessCommand_ReturnsUpperCase()
        {
            var processor = new VoiceCommandProcessor();
            string result = processor.ProcessCommand("turn on lights");

            Assert.Equal("TURN ON LIGHTS", result);
            Assert.Single(processor.CommandHistory);
        }

        [Fact]
        public void CommandHistory_AccumulatesCommands()
        {
            var processor = new VoiceCommandProcessor();
            processor.ProcessCommand("first");
            processor.ProcessCommand("second");

            Assert.Equal(2, processor.CommandHistory.Count);
        }
    }
}
