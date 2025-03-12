using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation.Test
{
    public class LightManagementTests
    {
        [Fact]
        public void TestSetScene()
        {
            var coreSystem = new CoreSystem();
            var lightManagement = new LightManagement(coreSystem);
            lightManagement.SetScene("Reading");
            Assert.Equal("Reading", coreSystem.GetState("light"));
        }
    }
}
