import java.util.ArrayList;

public class ClasseCriptografica {

    public static String encripta(String messatge, String key) {
        ArrayList<String> encrypted = new ArrayList<>(); 

        for (int i = 0; i < messatge.length(); i++) {
            // m = posició de cada lletra del missatge
            char m = messatge.charAt(i);

            // k = posició de cada lletra de la clau i 
            // la llargada de la clau per poder aplicar el vigenere
            char k = key.charAt(i % key.length());

            // xor = entre els dos caràcters
            // Agafa el unicode de cada lletra
            // El resultat és el caràcter xifrat.
            int xor = m ^ k;
            encrypted.add(String.valueOf(xor));

        }
        // Concatenar 
        // S'ajunten tots els números separats per comes
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