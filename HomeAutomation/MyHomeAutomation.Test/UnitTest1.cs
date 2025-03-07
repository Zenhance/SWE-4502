using MyHomeAutomation;
namespace MyHomeAutomation.Test
{
    public class UnitTest1
    {
        [Fact]
        public void DummyTest()
        {
            DummyClass c = new DummyClass();
            Assert.Equal("Hello", c.DummyMethod());
        }
    }
}