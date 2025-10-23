package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;
import java.util.Random;

public class PiedrapapelytijeravsBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Elige un Número");
        System.out.println("1 = Piedra");
        System.out.println("2 = Papel");
        System.out.println("3 = Tijera");

        System.out.println("Jugador 1 :  ");
        int valorJugadorUno = scanner.nextInt();
        if (valorJugadorUno == 1) {
            System.out.println("El Jugador Uno eligió : Piedra ");
        }
        if (valorJugadorUno == 2) {
            System.out.println("El Jugador Uno eligió : Papel ");
        }
        if (valorJugadorUno == 3) {
            System.out.println("El Jugador Uno eligió : Tijera ");
        }

        int valorBot = random.nextInt(3) + 1;
        if (valorBot == 1) {
            System.out.println("El bot eligió : Piedra ");
        }
        if (valorBot == 2) {
            System.out.println("El bot eligió : Papel ");
        }
        if (valorBot == 3) {
            System.out.println("El bot eligió : Tijera ");
        }

        if (valorJugadorUno < 1 || valorJugadorUno > 3) {
            System.out.println("Números no válidos . Usa 1 , 2 o 3 ");
        } else {
            int resultado = (valorJugadorUno - valorBot + 3) % 3;
            if (resultado == 0)
                System.out.println("Empate");

            else if (resultado == 1)
                System.out.println("Gana el Jugador 1 ");

            else
                System.out.println("Gana el Bot ");
        }
        scanner.close();

    }

}
