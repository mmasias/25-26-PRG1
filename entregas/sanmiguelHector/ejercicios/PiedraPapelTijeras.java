package entregas.sanmiguelHector.ejercicios;
import java.util.Scanner;
import java.util.Random;

public class PiedraPapelTijeras {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige: 0 para Piedra, 1 para Papel o 2 para Tijeras");
        int eleccionUsuario = scanner.nextInt();

        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(3);

        if (numeroAleatorio == 0) {
            System.out.println("La computadora eligió: Piedra");
        }
        if (numeroAleatorio == 1) {
            System.out.println("La computadora eligió: Papel");
        }
        if (numeroAleatorio == 2) {
            System.out.println("La computadora eligió: Tijeras");
        }

        if (eleccionUsuario == numeroAleatorio) {
            System.out.println("Empate");
        } else if ((eleccionUsuario == 0 && numeroAleatorio == 2) ||
                   (eleccionUsuario == 1 && numeroAleatorio == 0) ||
                   (eleccionUsuario == 2 && numeroAleatorio == 1)) {
            System.out.println("¡Ganaste!");
        } else {
            System.out.println("Perdiste");
        }
        scanner.close();
    }
}