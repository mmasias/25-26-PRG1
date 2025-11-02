package entregas.sanmiguelHector.ejercicios;
import java.util.Random;
import java.util.Scanner;

public class JuegoDeAdivinarElNumeroExtendido {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Estoy pensando un número entre el 1 y el 100. Si estás cerca del número te lo diré. Adivínalo!!");
        int numeroPensadoPorOrdenador = new Random().nextInt(100) + 1;
        int numeroUsuario = scanner.nextInt();
        final int NUMERO_INTENTOS_MAXIMO = 10;
        int intento = 1;
        if (numeroUsuario == numeroPensadoPorOrdenador) {
            System.out.println("No me lo creo. Adivinaste a la primera. 1% posibilidades y 99% de fe");
        } else {
            while (intento < NUMERO_INTENTOS_MAXIMO) {

                if (numeroUsuario == numeroPensadoPorOrdenador) {
                    System.out.println("Adivinaste el número!!");
                    break;
                }

                String frio = "Frío. ";
                String tibio = "Tibio. ";
                String caliente = "Caliente. ";
                String mensaje = "";

                if (numeroUsuario < numeroPensadoPorOrdenador) {
                    if (numeroPensadoPorOrdenador - numeroUsuario > 10) {
                        mensaje = frio;
                    } else if (numeroPensadoPorOrdenador - numeroUsuario <= 10
                            && numeroPensadoPorOrdenador - numeroUsuario > 5) {
                        mensaje = tibio;
                    } else {
                        mensaje = caliente;
                    }
                    System.out.println(mensaje + "El número que he pensado es mayor. Prueba de nuevo.");
                    System.out.println("Te siguen quedando " + (NUMERO_INTENTOS_MAXIMO - intento) + " intentos.");
                    numeroUsuario = scanner.nextInt();
                    intento += 1;
                }
                if (numeroUsuario > numeroPensadoPorOrdenador) {
                    if (numeroPensadoPorOrdenador - numeroUsuario > 10) {
                        mensaje = frio;
                    } else if (numeroPensadoPorOrdenador - numeroUsuario <= 10
                            && numeroPensadoPorOrdenador - numeroUsuario > 5) {
                        mensaje = tibio;
                    } else {
                        mensaje = caliente;
                    }
                    System.out.println(mensaje + "El número que he pensado es menor. Prueba de nuevo.");
                    System.out.println("Te siguen quedando " + (NUMERO_INTENTOS_MAXIMO - intento) + " intentos.");
                    numeroUsuario = scanner.nextInt();
                    intento += 1;
                }
            }
            if (intento == NUMERO_INTENTOS_MAXIMO) {
                System.out.println("Agotaste los intentos. Que malo eres adivinando jajaja. El número era: "
                        + numeroPensadoPorOrdenador);
            }
        }
        scanner.close();
    }
}