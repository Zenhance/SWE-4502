import java.time.LocalDateTime;

public class Log {
    private String Description;
    private LocalDateTime CreatedAt;

    public Log(String Description) {
        this.Description= Description;
    }

    public String getDescription(){
        return Description;
    }

    public LocalDateTime getCreatedAt(){
        return CreatedAt;
    }

    public void logOperation(){
        System.out.println("Log Description: "+this.Description+ " CreatedAt: "+ this.CreatedAt);
    }


}
