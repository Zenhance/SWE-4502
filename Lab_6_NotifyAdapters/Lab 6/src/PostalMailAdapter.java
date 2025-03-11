public class PostalMailAdapter implements NotificationSender {
    private PostalMailAPI postalMailAPI;

    public PostalMailAdapter(PostalMailAPI postalMailAPI) {
        this.postalMailAPI = postalMailAPI;
    }

    @Override
    public void send(String recipient, String message) {

        String[] recipientDetails = recipient.split(",");
        String name = recipientDetails[0];
        String address = recipientDetails[1];
        //String postalCode = recipientDetails[2];

        postalMailAPI.sendPostalMail(name, address, "sdslak", message);
    }
}
