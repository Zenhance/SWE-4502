using HomeAutomation.Components;
using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{

    public class PerformanceTests
    {
        private class TestComponent : IComponent
        {
            public int NotificationCount { get; private set; } = 0;

            public void OnStateChanged(EnvironmentalState state)
            {
                NotificationCount++;
            }
        }

        [Fact]
        public void StateManager_Should_Handle_Many_Components_Efficiently()
        {
            // Arrange
            var stateManager = new StateManager();
            const int numComponents = 10000;
            var components = new List<TestComponent>();

            for (int i = 0; i < numComponents; i++)
            {
                var component = new TestComponent();
                stateManager.RegisterComponent(component);
            }

            // Act
            var stopwatch = Stopwatch.StartNew();
            stateManager.UpdateState(state => state.Temperature = 25);
            stopwatch.Stop();

            // Assert
            int totalNotifications = testComponents.Sum(c => c.NotificationCount);
            Assert.Equal(numComponents, totalNotifications);

            // Performance expectation: should complete within a reasonable time (e.g., 200ms)
            Assert.True(stopwatch.ElapsedMilliseconds < 500, "Performance test took too long!");
        }
    }

}
