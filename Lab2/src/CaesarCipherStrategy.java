public class CaesarCipherStrategy implements EncryptionStrategy {
    private int shift;

    public CaesarCipherStrategy(int shift) {
        this.shift = shift;
    }

    @Override
    public byte[] encrypt(String data, String key) {
        StringBuilder result = new StringBuilder();
        for (char character : data.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + shift) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString().getBytes();
    }

    @Override
    public String decrypt(byte[] encryptedData, String key) {
        String data = new String(encryptedData);
        StringBuilder result = new StringBuilder();
        for (char character : data.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base - shift + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
