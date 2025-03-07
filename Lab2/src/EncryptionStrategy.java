public interface EncryptionStrategy {
    byte[] encrypt(String data, String key) throws Exception;
    String decrypt(byte[] encryptedData, String key) throws Exception;
}
