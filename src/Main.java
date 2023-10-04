import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int decision;

        do {
            System.out.println("----------- Menú -----------");
            System.out.println("[1]. Capturar cadena de entrada");
            System.out.println("[2]. Creditos");
            System.out.println("[3]. Salir");
            System.out.print("Ingrese su elección: ");
            decision = Integer.parseInt(scanner.nextLine());

            switch (decision) {
                case 1:
                    clearScreen();
                    System.out.print("Cadena a validar: ");
                    input = scanner.nextLine().toUpperCase();

                    if (validarCadena(input)) {
                        System.out.println("Cadena válida.");
                    } else {
                        System.out.println("Cadena inválida.");
                    }
                    break;

                case 2:
                    clearScreen();
                    System.out.println("----------- Créditos -----------");
                    System.out.println("Estructura de Datos Aplicadas");
                    System.out.println("Nombre: Marco Antonio Chavez Baltierrez || 4C || 22170149");
                    System.out.println("Nombre: Jesus Alberto Ramirez Gonzalez  || 4C || 22170147");
                    break;

                case 3:
                    System.out.println("Saliendo del programa.");
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.print("¿Desea continuar? (S/N): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("S")) {
                break;
            }
            clearScreen();
        } while (true);

        System.out.println("Programa terminado.");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static boolean validarCadena(String cadena) {
        if (cadena.length() < 6) {
            System.out.println("La cadena debe tener al menos 6 caracteres");
            return false;
        }

        if (!esDigitoPar(cadena.charAt(0))) {
            System.out.println("El primer carácter debe ser un dígito par");
            return false;
        }

        String[] secciones = cadena.split("(?<=\\d)(?=[A-Z$&])|(?<=[A-Z$&])(?=\\d)");
        if (secciones.length != 2) {
            return false;
        }

        if (!(esVocalMayuscula(secciones[1].charAt(0)) || esVocalMayuscula(secciones[1].charAt(1)))) {
            System.out.println("La segunda sección debe comenzar con al menos una vocal mayúscula");
            return false;
        }

        if (secciones[1].length() < 2 || !esConsonanteMayuscula(secciones[1].charAt(secciones[1].length() - 1))) {
            System.out.println("La segunda sección debe terminar con una consonante y tener al menos 2 letras");
            return false;
        }

        int contadorDigitos = 0;
        for (char c : cadena.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorDigitos++;
            }
        }

        if (contadorDigitos < 4) {
            System.out.println("Debe haber al menos 4 dígitos en la cadena");
            return false;
        }

        int lastIndex = secciones[0].length() - 1;
        String lastSection = secciones[0];
        char lastChar = lastSection.charAt(lastIndex);

        if (esDigitoPar(lastChar)) {
            System.out.println("El último carácter de la primera sección no debe ser un dígito par");
            return false;
        }

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
