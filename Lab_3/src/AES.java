import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES implements EncryptionStrategy{

    @Override
    public String encryptData(String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, IllegalBlockSizeException, InvalidKeyException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES key size, can also use 192 or 256 bits
        SecretKey secretKey = keyGen.generateKey();


        // Get the cipher instance for AES
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize the cipher in encryption mode with a secret key
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);  // Ensure 'key' is defined elsewhere

        // Encrypt the plaintext string
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Return the encrypted data as a Base64 encoded string
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


}
