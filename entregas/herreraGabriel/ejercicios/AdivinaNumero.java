import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {
    public static void main(String[] args) {
        final int NUMERO_MINIMO = 1;
        final int NUMERO_MAXIMO = 100;
        final int INTENTOS_MAXIMOS = 10;
        final int DIFERENCIA_CALIENTE = 5;
        final int DIFERENCIA_TIBIO = 10;
        final int MAXIMO_TRAMPA = 5;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(NUMERO_MAXIMO) + NUMERO_MINIMO;
        int intentosRealizados = 0;
        boolean numeroAdivinado = false;
        int contadorCaliente = 0;

        System.out.println("=================================");
        System.out.println("ADIVINA EL NÚMERO!");
        System.out.println("=================================");
        System.out.println("Estoy pensando en un número entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO);
        System.out.println("Tienes " + INTENTOS_MAXIMOS + " intentos para adivinarlo.");
        System.out.println();

        while (intentosRealizados < INTENTOS_MAXIMOS && !numeroAdivinado) {
            intentosRealizados++;
            System.out.print("Intento " + intentosRealizados + "/" + INTENTOS_MAXIMOS + " - Introduce tu número: ");

            int numeroUsuario = scanner.nextInt();

            if (numeroUsuario < NUMERO_MINIMO || numeroUsuario > NUMERO_MAXIMO) {
                System.out.println(
                        "¡Por favor, introduce un número entre " + NUMERO_MINIMO + " y " + NUMERO_MAXIMO + "!");
                intentosRealizados--;
                continue;
            }

            int diferencia = Math.abs(numeroSecreto - numeroUsuario);

            if (numeroUsuario == numeroSecreto) {
                numeroAdivinado = true;
                System.out.println();
                System.out.println("🎉 ¡¡¡FELICIDADES!!! 🎉");
                System.out.println(
                        "¡Has adivinado el número " + numeroSecreto + " en el intento " + intentosRealizados + "!");
            } else {
                String pistaMayorMenor = numeroUsuario < numeroSecreto ? "El número es MAYOR" : "El número es MENOR";

                String pistaTemperatura;
                if (diferencia <= DIFERENCIA_CALIENTE) {
                    pistaTemperatura = "¡CALIENTE! ";
                    contadorCaliente++;
                } else if (diferencia <= DIFERENCIA_TIBIO) {
                    pistaTemperatura = "Tibio ";
                    contadorCaliente = 0;
                } else {
                    pistaTemperatura = "Frío ";
                    contadorCaliente = 0;
                }

                System.out.println(pistaMayorMenor + " - " + pistaTemperatura);

                if (contadorCaliente >= 2) {
                    int valorTrampa = random.nextInt(MAXIMO_TRAMPA) + 1;
                    boolean sumarORestar = random.nextBoolean();
                    int nuevoNumero = sumarORestar ? numeroSecreto + valorTrampa : numeroSecreto - valorTrampa;

                    if (nuevoNumero >= NUMERO_MINIMO && nuevoNumero <= NUMERO_MAXIMO) {
                        numeroSecreto = nuevoNumero;
                        System.out.println("*Achu* (El ordenador estornuda sospechosamente...)");
                        contadorCaliente = 0;
                    }
                }

                int intentosRestantes = INTENTOS_MAXIMOS - intentosRealizados;
                String mensajeIntentos = intentosRestantes > 0 ? "Te quedan " + intentosRestantes + " intentos." : "";
                if (intentosRestantes > 0) {
                    System.out.println(mensajeIntentos);
                }
                System.out.println();
            }
        }

        if (!numeroAdivinado) {
            System.out.println(" Se acabaron los intentos!");
            System.out.println("El número era: " + numeroSecreto);
            System.out.println("Mejor suerte la próxima vez!");
        }

        scanner.close();
    }
}