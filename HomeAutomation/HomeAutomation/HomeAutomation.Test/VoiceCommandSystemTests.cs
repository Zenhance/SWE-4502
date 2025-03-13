using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Test
{
    public class VoiceCommandSystemTests
    {
        [Fact]
        public void TestTranslateCommand()
        {
            var coreSystem = new CoreSystem();
            var voiceCommandSystem = new VoiceCommandSystem(coreSystem);
            voiceCommandSystem.TranslateCommand("Turn on lights");
            Assert.Equal("Turn on lights", coreSystem.GetState("command"));
        }
    }
}
