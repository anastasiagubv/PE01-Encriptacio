import java.util.Scanner;

public class ProgramaPrincipal {
    Scanner sc = new Scanner(System.in);

    String messatge = "";
    String key = "";
    String keyInput = "";
    String encryptedMessatge = "";
    String desencryptedMessatge = "";

    public static void main(String[] args) {
        ProgramaPrincipal s = new ProgramaPrincipal();
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
        // Obtenir clau
        key = readString("Introdueix la clau en format de text: ");

        // Obtenir missatge
        messatge = readString("Introdueix el teu missatge: ");

        // Encriptar
        encryptedMessatge = ClasseCriptografica.encripta(messatge, key);

        // Desencriptar
        keyInput = readString("Introdueix la clau per desencriptar el missatge: ");
        desencryptedMessatge = ClasseCriptografica.desencripta(encryptedMessatge, keyInput);

        showResults();
    }

    public void showResults() {
        System.out.println("\nEncriptació:");
        System.out.println("Missatge original: " + messatge);
        System.out.println("Missatge encriptat: " + encryptedMessatge);
        System.out.println("Missatge desencriptat: " + desencryptedMessatge);
        System.out.println("Clau d'encriptació: " + key);
        System.out.println("Clau de desencriptació: " + keyInput);

        if (messatge.equals(desencryptedMessatge)) {
            System.out.println("Correcte: sí");
        } else {
            System.out.println("Correcte: no");
        }
    }
}
