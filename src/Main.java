import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Cadena a validar: ");
            input = scanner.nextLine().toUpperCase();

            if (validarCadena(input)) {
                System.out.println("Cadena válida.");
            } else {
                System.out.println("Cadena inválida.");
            }

            System.out.print("Seguir? (S/N): ");
            if (!scanner.nextLine().toUpperCase().equals("S")) {
                break;
            }

        } while (true);

        System.out.println("Programa terminado.");
    }

    public static boolean validarCadena(String cadena) {
        // Verificar la longitud mínima de la cadena
        if (cadena.length() < 6) {
            System.out.println("Longitud de cadena");
            return false;
        }

        // Verificar que comience y termine con números pares
        if (!esDigitoPar(cadena.charAt(0)) || !esDigitoPar(cadena.charAt(cadena.length() - 1))) {
            System.out.println("Numero par inicio");

            return false;
        }

        // Verificar la presencia de los signos $ o &
        if (cadena.contains("$") && !cadena.contains("&")) {
            System.out.println("Signos");
        }

        // Dividir la cadena en dos secciones separadas por el último signo encontrado
        String[] secciones = cadena.split("[$&]");
        if (secciones.length != 2) {
            System.out.println("4");

            return false;
        }

        // Verificar que la primera sección comience con una vocal
        if (!esVocalMayuscula(secciones[1].charAt(0))) {
            System.out.println("5");

            return false;
        }

        // Verificar que la segunda sección termine con una consonante y tenga al menos 2 letras
        if (secciones[1].length() < 2 || !esConsonanteMayuscula(secciones[1].charAt(secciones[1].length() - 1))) {
            System.out.println("6");

            return false;
        }

        // Contar la cantidad de dígitos en la cadena
        int contadorDigitos = 0;
        for (char c : cadena.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorDigitos++;
            }
        }

        // Verificar que haya al menos 4 dígitos
        if (contadorDigitos < 4) {
            System.out.println("7");

            return false;
        }

        // Si todas las condiciones se cumplen, la cadena es válida
        return true;
    }

    public static boolean esDigitoPar(char c) {
        int digito = c - '0';
        return digito % 2 == 0;
    }

    public static boolean esVocalMayuscula(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static boolean esConsonanteMayuscula(char c) {
        return Character.isLetter(c) && !esVocalMayuscula(c);
    }
}
