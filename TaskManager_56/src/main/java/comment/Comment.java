package comment;

import user.User;

import java.util.Date;

public class Comment {

    public Integer id;
    public String content;
    public Integer author;
    public Date createdAt;

    public Comment(Integer id,String content,Integer author){
        this.id=id;
        this.content=content;
        this.author=author;
    }

}
