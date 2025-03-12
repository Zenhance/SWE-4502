using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation.Test
{
    public class CoreSystemTests
    {
        [Fact]
        public void TestSetState()
        {
            var coreSystem = new CoreSystem();
            coreSystem.SetState("testKey", "testValue");
            Assert.Equal("testValue", coreSystem.GetState("testKey"));
        }
    }
}
