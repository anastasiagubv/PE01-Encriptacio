import java.util.ArrayList;

public class ClasseCriptografica {

    public static String encripta(String messatge, String key) {
        ArrayList<String> encrypted = new ArrayList<>(); 

        for (int i = 0; i < messatge.length(); i++) {
            // m = posició missatge
            char m = messatge.charAt(i);

            // k = posició clau
            char k = key.charAt(i % key.length());

            int xor = m ^ k;
            encrypted.add(String.valueOf(xor));
        }

        String encryptedMessatge = String.join(",", encrypted);
        return encryptedMessatge;
    }

    public static String desencripta(String encryptedMessatge, String key) {
        String[] parts = encryptedMessatge.split(",");
        ArrayList<String> desencrypted = new ArrayList<>(); 

        for (int i = 0; i < parts.length; i++) {
            int em = Integer.parseInt(parts[i]);

            char k = key.charAt(i % key.length());

            int reverseXor = em ^ k;
            desencrypted.add(String.valueOf((char) reverseXor));
        }
        String messatge = String.join("", desencrypted);
        return messatge;
    }
} 