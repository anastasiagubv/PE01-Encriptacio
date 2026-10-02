package src;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ClasseAES {

    public static String encripta(String messatge, String key) {
        try {
            // Clau
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // Missatge
            byte[] messatgeBytes = messatge.getBytes(StandardCharsets.UTF_8);

            byte[] encryptedBytes = cipher.doFinal(messatgeBytes);

            String messatgeString = Base64.getEncoder().encodeToString(encryptedBytes);
            return messatgeString;

        } catch (Exception e) {
            System.out.println("Error en encriptar: " + e.getMessage());
            return null;
        }
    }

    public static String desencripta(String encryptedMessatge, String key){
        try {
            // Clau
            byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessatge);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            String messatge = new String(decryptedBytes, StandardCharsets.UTF_8);
            return messatge;
            
        } catch (Exception e) {
            System.out.println("Error en desencriptar: " + e.getMessage());
            return null;
        }
    }
}