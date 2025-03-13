using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class RemoteAccessAppTests
    {
        [Fact]
        public void TestRemoteControl()
        {
            var coreComponent = new CoreComponent();

            var remoteAccessApp = new RemoteAccessApp(coreComponent);
            remoteAccessApp.RemoteControl("Turn off HVAC");
            Assert.Equal("Turn off HVAC", coreComponent.GetState("notification"));
        }
    }
}
