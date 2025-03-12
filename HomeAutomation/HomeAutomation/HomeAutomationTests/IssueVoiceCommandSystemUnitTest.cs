using HomeAutomation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTests
{
    public class IssueVoiceCommandSystemUnitTest
    {
        private readonly StringWriter stringWriter;
        public IssueVoiceCommandSystemUnitTest()
        {
            stringWriter = new StringWriter();
        }

        [Fact]
        public void ShouldTurnOnLightVoiceCommand()
        {
            var voiceCommandSystem = new VoiceCommand();
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(voiceCommandSystem);

            Console.SetOut(stringWriter);
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Hallway");


            Assert.Contains("Voice Command: Turning the light on.", stringWriter.ToString());
        }

    }
}
