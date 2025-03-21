using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TrelloApp.Test
{
    public class AddCommentTest
    {
        [Fact]
        public void AddComment_ShouldAddCommentToIssue()
        {
            int id = 1;
            Comment comment = new Comment(id, "Content nai", "Labib", 21);
            Issue issue = new Issue();

            issue.addComment(comment);

            var commentInfo = issue.comments[id-1];

            Assert.Equal(id, commentInfo.id);
            Assert.Equal(comment.content, commentInfo.content);
            Assert.Equal(comment.author, commentInfo.author);
            Assert.Equal(comment.createdAt, commentInfo.createdAt);

        }
    }
}
