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

    public class TestObserver : IComponent
    {
        private readonly System.Action _onNotify;
        public TestObserver(System.Action onNotify)
        {
            _onNotify = onNotify;
        }
        public void OnStateChanged(EnvironmentalState state)
        {
            _onNotify();
        }
    }

    public class PerformanceTests
    {
        [Fact]
        public void StateManager_Performance_WithManyObservers()
        {
           
            var stateManager = new StateManager();
            const int observerCount = 10000;
            int notificationCount = 0;

            for (int i = 0; i < observerCount; i++)
            {
                stateManager.RegisterComponent(new TestObserver(() => { notificationCount++; }));
            }

            
            var stopwatch = Stopwatch.StartNew();
            stateManager.UpdateState(state => {
                state.Temperature = 22;
                state.AmbientLight = 50;
                state.MotionDetected = false;
            });
            stopwatch.Stop();

          
            Assert.Equal(observerCount, notificationCount);
            
            Assert.True(stopwatch.ElapsedMilliseconds < 1000, $"Performance issue: {stopwatch.ElapsedMilliseconds}ms elapsed");
        }
    }
    
}
