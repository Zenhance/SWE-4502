using System;

public class Comment
{
	public Comment()
	{
		public int ID;
		public string Content;
		public string Author;
		public dateTime CreatedAt;

        public Comment(int ID, string Content, string Author, dateTime CreatedAt)
        {
        this.ID = ID;
        this.Content = Content;
        this.Author = Author;
        this.CreatedAt = CreatedAt;
        }
}
