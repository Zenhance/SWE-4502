using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class VoiceCommandSystemTests
    {
        [Fact]
        public void TestTranslateCommand()
        {
            var coreComponent = new CoreComponent();

            var voiceCommandSystem = new VoiceCommandSystem(coreComponent);
            voiceCommandSystem.TranslateCommand("Turn on lights");
            Assert.Equal("Turn on lights", coreComponent.GetState("command"));
        }
    }
}
