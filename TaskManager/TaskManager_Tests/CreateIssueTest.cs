using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TaskManager;

namespace TaskManager_Tests
{
    [TestClass]
    public class CreateIssueTest
    {
        static HashSet<string> names = new HashSet<string>() { "Alice", "Bob" };
        static List<Comments> comments = new List<Comments>() ;

        Issue I1 = new Issue(1, "TEST1", "OK", Priority.Low, Status.Open, DateTime.Now, DateTime.Now, "Alif", names, comments);
        //IssueRepository IR1 = new 
        [TestMethod]
        public void CreateIssueTestMethod()
        {

        }
    }
}
