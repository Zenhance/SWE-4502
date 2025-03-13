using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class LightManagementTests
    {
        [Fact]
        public void TestSetScene()
        {
            var coreComponent = new CoreComponent();
            var lightManagement = new LightManagement(coreComponent);
            lightManagement.SetScene("Reading");
            Assert.Equal("Reading", coreComponent.GetState("light"));
        }
    }
}
