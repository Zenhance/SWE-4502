using src;

namespace UnitTest
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            var observer = new observer();

            int result = observer.add(2, 3);

            Assert.Equal(5, result);
        }
    }
}