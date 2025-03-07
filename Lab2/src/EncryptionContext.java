public class EncryptionContext {
    private EncryptionStrategy strategy;


    public void setEncryptionStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public byte[] encrypt(String data, String key) throws Exception {
        return strategy.encrypt(data, key);
    }

    public String decrypt(byte[] encryptedData, String key) throws Exception {
        return strategy.decrypt(encryptedData, key);
    }
}
