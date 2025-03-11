package Adaptee_Different_API;
public class TwitterAPI
{
    public void markTweetAsSeen() {
        System.out.println("Twitter notification marked as seen.");
    }

    public void markTweetAsUnseen() {
        System.out.println("Twitter notification marked as unseen.");
    }

    public void removeTweetNotification() {
        System.out.println("Twitter notification removed.");
    }
}
