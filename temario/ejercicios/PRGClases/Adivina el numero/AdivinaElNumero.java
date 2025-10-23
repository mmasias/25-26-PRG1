import java.util.Scanner;

 class AdivinaElNumero {
    public static void main(String[] args) {

        final int NUMERO_MAXIMO = 11;
        int numeroPensado;
        int valorAleatorio = (int) (Math.random() * NUMERO_MAXIMO);

        Scanner scanner = new Scanner(System.in);

        while (numeroUsuario != valorAleatorio) {}
        System.out.println("Adivina el numero entre 0 y " + (NUMERO_MAXIMO - 1) + ": ");
        int numeroUsuario = scanner.nextInt();  // Leer el número
        if (numeroUsuario != valorAleatorio) {  // Comparar números
            System.out.println("No has adivinado el numero");
        } else {
            System.out.println("Has adivinado el numero");
        }

    }
}