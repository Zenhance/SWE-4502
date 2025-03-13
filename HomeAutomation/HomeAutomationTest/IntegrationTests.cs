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
    public class IntegrationTests
    {
        [Fact]
        public void StateManager_Update_MultipleComponents_ReceiveNotification()
        {
           
            var stateManager = new StateManager();
            var motionDetector = new MotionDetector();
            var lightManager = new LightManager();
            var temperatureController = new TemperatureController(22);

            stateManager.RegisterComponent(motionDetector);
            stateManager.RegisterComponent(lightManager);
            stateManager.RegisterComponent(temperatureController);

      
            stateManager.UpdateState(state => {
                state.MotionDetected = true;
                state.AmbientLight = 15;  
                state.Temperature = 20;   
            });

          
            Assert.True(motionDetector.MotionDetected);
            Assert.True(lightManager.LightsOn);
            Assert.True(temperatureController.HeatingOn);
        }

        [Fact]
        public void StateManager_Update_WithEnergyTrackerAndVoiceCommandProcessor()
        {
           
            var stateManager = new StateManager();
            var energyTracker = new EnergyTracker();
            var voiceProcessor = new VoiceCommandProcessor();

            stateManager.RegisterComponent(energyTracker);
            stateManager.RegisterComponent(voiceProcessor);

           
            stateManager.UpdateState(state => {
                state.AmbientLight = 10; 
                state.Temperature = 25;
                state.MotionDetected = false;
            });

           
            Assert.Equal(7, energyTracker.CurrentPowerUsage);

            string commandResult = voiceProcessor.ProcessCommand("open door");
            Assert.Equal("OPEN DOOR", commandResult);
            Assert.Single(voiceProcessor.CommandHistory);
        }

        [Fact]
        public void RemoteAccessApp_Integration_Test()
        {
           
            var stateManager = new StateManager();
            var remoteApp = new RemoteAccessApp();

            stateManager.RegisterComponent(remoteApp);

           
            stateManager.UpdateState(state => {
                state.Temperature = 18;
                state.AmbientLight = 80;
                state.MotionDetected = true;
            });

         
            Assert.NotNull(remoteApp.CurrentState);
            Assert.Equal(18, remoteApp.CurrentState.Temperature);
            Assert.Equal(80, remoteApp.CurrentState.AmbientLight);
            Assert.Contains("Motion detected!", remoteApp.Notifications);

            string display = remoteApp.GetDisplay();
            Assert.Contains("Temp: 18", display);
            Assert.Contains("Light: 80", display);
        }

        [Fact]
        public void Integration_AllComponents_Combined_Test()
        {
           
            var stateManager = new StateManager();
            var motionDetector = new MotionDetector();
            var lightManager = new LightManager();
            var temperatureController = new TemperatureController(22);
            var energyTracker = new EnergyTracker();
            var voiceProcessor = new VoiceCommandProcessor();
            var remoteApp = new RemoteAccessApp();

            stateManager.RegisterComponent(motionDetector);
            stateManager.RegisterComponent(lightManager);
            stateManager.RegisterComponent(temperatureController);
            stateManager.RegisterComponent(energyTracker);
            stateManager.RegisterComponent(voiceProcessor);
            stateManager.RegisterComponent(remoteApp);

            
            stateManager.UpdateState(state => {
                state.MotionDetected = true;
                state.AmbientLight = 10;  
                state.Temperature = 20;   
            });

            
            Assert.True(motionDetector.MotionDetected);
            Assert.True(lightManager.LightsOn);
            Assert.True(temperatureController.HeatingOn);
            
            Assert.Equal(7, energyTracker.CurrentPowerUsage);
           
            Assert.NotNull(remoteApp.CurrentState);
            Assert.Equal(20, remoteApp.CurrentState.Temperature);
            Assert.Equal(10, remoteApp.CurrentState.AmbientLight);
            Assert.Contains("Motion detected!", remoteApp.Notifications);

           
            string processedCommand = voiceProcessor.ProcessCommand("dim lights");
            Assert.Equal("DIM LIGHTS", processedCommand);
            Assert.Single(voiceProcessor.CommandHistory);
        }


    }
}
