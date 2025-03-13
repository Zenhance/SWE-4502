using Xunit;
using HomeAutomation.Components;
using HomeAutomation.Core_Model;
using System.Collections.Generic;

namespace TestProject1
{
    public class TestVoiceCommand
    {
        [Fact]
        public void Test_VoiceCommand_InitialState()
        {
            VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
            CentralState state = new CentralState { VoiceCommand = "" };

            voiceSystem.Update(state);

            Assert.Empty(voiceSystem.CommandHistory);
            Assert.Equal("", voiceSystem.LastCommand);
        }

        [Fact]
        public void Test_VoiceCommand_StoreCommand()
        {
            VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
            CentralState state = new CentralState { VoiceCommand = "Turn on the lights" };

            voiceSystem.Update(state);

            Assert.Single(voiceSystem.CommandHistory);
            Assert.Equal("Turn on the lights", voiceSystem.LastCommand);
        }

        [Fact]
        public void Test_VoiceCommand_MultipleCommands()
        {
            VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
            voiceSystem.Update(new CentralState { VoiceCommand = "Turn on AC" });
            voiceSystem.Update(new CentralState { VoiceCommand = "Set temperature to 22" });
            voiceSystem.Update(new CentralState { VoiceCommand = "Turn off AC" });

            Assert.Equal(3, voiceSystem.CommandHistory.Count);
            Assert.Equal("Turn off AC", voiceSystem.LastCommand);
        }

        [Fact]
        public void Test_VoiceCommand_IgnoresEmptyCommand()
        {
            VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
            voiceSystem.Update(new CentralState { VoiceCommand = "" });

            Assert.Empty(voiceSystem.CommandHistory);
            Assert.Equal("", voiceSystem.LastCommand);
        }

        [Fact]
        public void Test_VoiceCommand_ExecuteCommand()
        {
            VoiceCommandSystem voiceSystem = new VoiceCommandSystem();
            CentralState state = new CentralState { VoiceCommand = "Turn on heater" };

            voiceSystem.Update(state);

            Assert.Contains("Turn on heater", voiceSystem.CommandHistory);
            Assert.Equal("Turn on heater", voiceSystem.LastCommand);
        }
    }
}
