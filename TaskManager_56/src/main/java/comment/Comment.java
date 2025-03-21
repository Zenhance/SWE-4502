package comment;

import user.User;

import java.util.Date;

public class Comment {
    public String id;
    public String content;
    public User author;
    public Date createdAt;

    public Comment(String id,String content,User author){
        this.id=id;
        this.content=content;
        this.author=author;
    }

}
