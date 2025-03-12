using HomeAutomation;

namespace HomeAutomationTests
{
    public class IssueRemoteAccessAppUnitTest
    {
        private readonly StringWriter stringWriter;
        public IssueRemoteAccessAppUnitTest()
        {
            stringWriter = new StringWriter();
        }
        [Fact]
        public void ShouldControlSystemSuccessfully()
        {
            var homeEnvironment = new HomeEnvironment();
            var remoteAccessApp = new RemoteAccess(homeEnvironment);

            remoteAccessApp.ControlSystem(true);

            Assert.True(homeEnvironment.isMotionDetected);
        }

    }
}
