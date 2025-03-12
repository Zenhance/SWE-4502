using HomeAutomation.Core;
using Moq;
using Xunit;

namespace HomeAutomationTest
{
    public class StateManagerTests
    {
        [Fact]
        public void RegisterComponent_AddsComponentOnce()
        {
            var stateManager = new StateManager();
            var mockComponent = new Mock<IComponent>();

            stateManager.RegisterComponent(mockComponent.Object);
           
            stateManager.RegisterComponent(mockComponent.Object);

           
            stateManager.UpdateState(state => { state.Temperature = 25; });
            mockComponent.Verify(c => c.OnStateChanged(It.IsAny<EnvironmentalState>()), Times.Once);
        }

        [Fact]
        public void UpdateState_NotifiesRegisteredComponents()
        {
            var stateManager = new StateManager();
            var mockComponent1 = new Mock<IComponent>();
            var mockComponent2 = new Mock<IComponent>();

            stateManager.RegisterComponent(mockComponent1.Object);
            stateManager.RegisterComponent(mockComponent2.Object);

            stateManager.UpdateState(state => { state.AmbientLight = 50; });

            mockComponent1.Verify(c => c.OnStateChanged(It.Is<EnvironmentalState>(s => s.AmbientLight == 50)), Times.Once);
            mockComponent2.Verify(c => c.OnStateChanged(It.Is<EnvironmentalState>(s => s.AmbientLight == 50)), Times.Once);
        }
    }
}