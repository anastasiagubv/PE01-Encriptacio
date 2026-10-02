package src;
import java.util.Scanner;

public class ProgramaPrincipalAES {
    Scanner sc = new Scanner(System.in);

    String messatge = "Aquest és un missatge secret.";
    String key = "1234567890123456";
    String keyInput = "";
    String encryptedMessatge = "";
    String desencryptedMessatge = "";

    public static void main(String[] args) {
        ProgramaPrincipalAES s = new ProgramaPrincipalAES();
        s.start();
    }

    public void start() {
        menu();
    }

    public String readString(String prompt) {
        String input = "";
        boolean valid = false;

        do {
            System.out.print(prompt);
            try {
                input = sc.nextLine();

                if (input.trim().isEmpty()) {
                    System.out.println("Error: no pot estar buit. Torna-ho a provar.");
                    valid = false;
                } else {
                    valid = true;
                }

            } catch (Exception e) {
                System.out.println("Error: no s'ha pogut llegir l'entrada.");
                valid = false;
            }
        } while (!valid);

        return input;
    }

    public void menu() {
        System.out.println("Missatge original: " + messatge);

        // Encriptar
        encryptedMessatge = ClasseAES.encripta(messatge, key);
        if (encryptedMessatge == null) {
            System.out.println("No s'ha pogut encriptar el missatge.");
            return;
        }
        System.out.println("Missatge encriptat: " + encryptedMessatge);

        // Desencriptar
        keyInput = readString("Introdueix la clau per desencriptar el missatge: ");
        desencryptedMessatge = ClasseAES.desencripta(encryptedMessatge, keyInput);

        showResults();
    }

    public void showResults() {
        System.out.println("\nEncriptació AES:");
        System.out.println("Missatge original: " + messatge);
        System.out.println("Missatge encriptat: " + encryptedMessatge);
        System.out.println("Missatge desencriptat: " + desencryptedMessatge);
        System.out.println("Clau d'encriptació: " + key);
        System.out.println("Clau de desencriptació: " + keyInput);

        if (messatge.equals(desencryptedMessatge)) {
            System.out.println("Correcte: sí");
        } else {
            System.out.println("Correcte: no");
            System.out.println("Raó: claus diferents!");
        }
    }
}
