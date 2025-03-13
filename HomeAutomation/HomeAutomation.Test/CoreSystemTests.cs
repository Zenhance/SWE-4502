using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using System.Collections.Generic;
using HomeAutomation.Core;


namespace HomeAutomation.Test
{
    [TestClass]
    public class CoreSystemTests
    {
        private CoreSystem coreSystem;

        [TestInitialize]
        public void Setup()
        {
            coreSystem = new CoreSystem();
        }

        [TestMethod]
        public void RegisterComponent_Should_Add_Component_To_Observers()
        {
            var mockComponent = new Mock<IComponent>();
            coreSystem.RegisterComponent(mockComponent.Object);

            Assert.IsTrue(coreSystem.HasComponent(mockComponent.Object));
        }

        [TestMethod]
        public void NotifyComponents_Should_Trigger_Updates()
        {
            var mockComponent = new Mock<IComponent>();
            coreSystem.RegisterComponent(mockComponent.Object);

            coreSystem.NotifyComponents("temperature", 25);

            mockComponent.Verify(c => c.Update("temperature", 25), Times.Once);
        }
    }
}
