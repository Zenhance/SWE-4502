using System;

public class Issue
{
	public Issue()
	{
		public int ID;
		public string title;
		public string description;
        public enum priority { Low, Medium, High, Critical}
		public enum status { Open, InProgress,UnderReview, Resolved, Closed }
        public Date CreationDate;
		public Date LastModifiedDate;
		public string AssignedTo;
		public string Tags[];

		public Issue(int ID, string title, string description, enum priority, string status, Date CreationDate, Date LastModifiedDate, string AssignedTo, string Tags[])
        {
            this.ID = ID;
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.status = status;
            this.CreationDate = CreationDate;
            this.LastModifiedDate = LastModifiedDate;
            this.AssignedTo = AssignedTo;
            this.Tags = Tags;
        }

        public void AddComment(Comment comment)
        {
             Comments.add(comment);
             LastModifiedDate = DateTime.Now;

        }

	}
}
