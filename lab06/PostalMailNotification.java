public class PostalMailNotification implements Notification {
    private PostalMailAPI postalMailAPI;
    private String recipientAddress;
    private String recipientName;

    public PostalMailNotification(String recipientAddress, String recipientName) {
        this.postalMailAPI = new PostalMailAPI(); // Initialize 3rd party API
        this.recipientAddress = recipientAddress;
        this.recipientName = recipientName;
    }

    @Override
    public void send(String message) {
        // Use the 3rd party API to send the postal mail
        postalMailAPI.sendPostalMail(recipientAddress, recipientName, message);
    }
}
