using MyHomeAutomation.DummyClasses;
namespace MyHomeAutomation.Test.DummyUnitTests
{
    public class DummyUnitTest
    {
        [Fact]
        public void DummyTest()
        {
            var c = new DummyClass();
            Assert.Equal("Hello", c.DummyMethod());
        }
    }
}