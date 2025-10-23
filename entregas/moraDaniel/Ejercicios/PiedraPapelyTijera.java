package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;

class PiedraPapelyTijera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un Número");
        System.out.println("1 = Piedra");
        System.out.println("2 = Papel");
        System.out.println("3 = Tijera");

        System.out.println("Jugador 1 :  ");
        int valorJugadorUno = scanner.nextInt();

        System.out.println("Jugador 2 :  ");
        int valorJugadorDos = scanner.nextInt();

        if (valorJugadorUno < 1 || valorJugadorUno > 3 || valorJugadorDos < 1 || valorJugadorDos > 3) {
            System.out.println("Números no válidos . Usa 1 , 2 o 3 ");
        } else {
            int resultado = (valorJugadorUno - valorJugadorDos + 3) % 3;
            if (resultado == 0)
                System.out.println("Empate");

            else if (resultado == 1)
                System.out.println("Gana el Jugador 1 ");

            else
                System.out.println("Gana Jugador 2 ");
        }
        scanner.close();

    }

}
