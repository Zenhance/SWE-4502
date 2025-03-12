using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation.Test
{
    public class RemoteAccessAppTests
    {
        [Fact]
        public void TestRemoteControl()
        {
            var coreSystem = new CoreSystem();
            var remoteAccessApp = new RemoteAccessApp(coreSystem);
            remoteAccessApp.RemoteControl("Turn off HVAC");
            Assert.Equal("Turn off HVAC", coreSystem.GetState("notification"));
        }
    }
}
