package src;
import java.util.ArrayList;

public class ClasseCriptografica {

    public static String encripta(String messatge, String key) {
        ArrayList<String> encrypted = new ArrayList<>(); 

        for (int i = 0; i < messatge.length(); i++) {
            // m = posició missatge
            char m = messatge.charAt(i);

            // k = posició clau + vigènere
            char k = key.charAt(i % key.length());

            // xor del caràcter del missatge i el de la clau
            int xor = m ^ k;
            encrypted.add(String.valueOf(xor));
        }

        // guardo els números separats per comes ex: (72,4,15,..)
        String encryptedMessatge = String.join(",", encrypted);
        return encryptedMessatge;
    }

    public static String desencripta(String encryptedMessatge, String key) {
        // separo els números guardats
        String[] parts = encryptedMessatge.split(",");
        ArrayList<String> desencrypted = new ArrayList<>(); 

        // mateix procediment que encripta
        for (int i = 0; i < parts.length; i++) {
            int em = Integer.parseInt(parts[i]);

            char k = key.charAt(i % key.length());

            int reverseXor = em ^ k;

            // el mateix que encripta pero passant el int a char per obtenir el la lletra
            desencrypted.add(String.valueOf((char) reverseXor));
        }

        String messatge = String.join("", desencrypted);
        return messatge;
    }
}