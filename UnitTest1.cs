using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

using dpfinal_200042152;

namespace finaltest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            var taskissue = new TaskManager(20, "new issue", "hard dp", Priority.High,"me");
            taskissue.Tags.Add("ui");
            taskissue.AddComment(new Comment(1,"a","b",DateTime.Now));

            var clonedTask=(TaskManager) taskissue.Clone();  

            Assert.AreEqual(taskissue.Title, clonedTask.Title);
             Assert.AreEqual(taskissue.Priority, clonedTask.Priority);
            Assert.AreEqual(clonedTask.Description, clonedTask.Description);


        }

        [TestMethod]
         public void AddComment_ShouldAddCommentToIssue()
        {

            var taskissue = new TaskManager(20, "new issue", "hard dp", Priority.High, "me");
            taskissue.Tags.Add("ui");
            taskissue.AddComment(new Comment(1, "a", "b", DateTime.Now));
            var clonedTask = (TaskManager)taskissue.Clone();

            Assert.AreEqual(taskissue.Comments.Count, clonedTask.Comments.Count);   

        }

        [TestMethod]

        public void ChangeStatus_ShouldUpdateIssueStatus()
        {

            var taskissue = new TaskManager(20, "new issue", "hard dp", Priority.High, "me");
            taskissue.Tags.Add("ui");
            taskissue.AddComment(new Comment(1, "a", "b", DateTime.Now));
            taskissue.Status = Status.Closed;
            var clonedTask = (TaskManager)taskissue.Clone();
       
            Assert.AreEqual(taskissue.Status, clonedTask.Status);

          
        }
    }
}
