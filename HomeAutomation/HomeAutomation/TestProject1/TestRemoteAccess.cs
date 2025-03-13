using Xunit;
using HomeAutomation.Components;
using HomeAutomation.Core_Model;
using System.Collections.Generic;

namespace TestProject1
{
    public class TestRemoteAccess
    {
        [Fact]
        public void Test_RemoteAccess_InitialState()
        {
            RemoteAccessApp remoteAccess = new RemoteAccessApp();
            CentralState state = new CentralState { MotionDetected = false, LightLevel = 50, Temperature = 22, EnergyUsage = 5.0, VoiceCommand = "" };

            remoteAccess.Update(state);

            Assert.Single(remoteAccess.Notifications);
            Assert.Contains("State updated", remoteAccess.Notifications[0]);
        }

        [Fact]
        public void Test_RemoteAccess_MultipleUpdates()
        {
            RemoteAccessApp remoteAccess = new RemoteAccessApp();
            CentralState state1 = new CentralState { MotionDetected = true, LightLevel = 80, Temperature = 24, EnergyUsage = 6.5, VoiceCommand = "Turn on lights" };
            CentralState state2 = new CentralState { MotionDetected = false, LightLevel = 30, Temperature = 20, EnergyUsage = 4.2, VoiceCommand = "Turn off lights" };

            remoteAccess.Update(state1);
            remoteAccess.Update(state2);

            Assert.Equal(2, remoteAccess.Notifications.Count);
        }

        [Fact]
        public void Test_RemoteAccess_LatestStateStored()
        {
            RemoteAccessApp remoteAccess = new RemoteAccessApp();
            CentralState state = new CentralState { MotionDetected = true, LightLevel = 60, Temperature = 23, EnergyUsage = 7.0, VoiceCommand = "Increase temperature" };

            remoteAccess.Update(state);

            Assert.Equal(60, remoteAccess.CurrentState.LightLevel);
            Assert.True(remoteAccess.CurrentState.MotionDetected);
            Assert.Equal("Increase temperature", remoteAccess.CurrentState.VoiceCommand);
        }
    }
}
