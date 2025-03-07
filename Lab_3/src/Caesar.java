public class Caesar implements EncryptionStrategy{

    public String encryptData(String plainText) {
        int shift = EncFactory.getCaesarShift();  // Get the Caesar cipher shift value
        StringBuilder encryptedText = new StringBuilder();

        // Loop through each character in the plainText
        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';  // Check if it's uppercase or lowercase
                // Apply the shift and ensure it wraps around the alphabet using modulo 26
                char shifted = (char) ((c - base + shift) % 26 + base);
                encryptedText.append(shifted);
            } else {
                // Non-alphabetic characters remain unchanged
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();  // Return the encrypted text
    }
}
