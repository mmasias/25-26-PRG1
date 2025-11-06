package entregas;

import java.util.Scanner;
import java.util.Random;

class CarreraCamellos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERA_PISTA = "[J]| ";
        final String CAMELLO = ";--;'";
        final int POSICION_FINAL = 60;

        int posicionJugador = 0;
        int numerodeTurno = 0;
        int fallosConsecutivos = 0;

        boolean alcanzoLaMeta = false;

        do {
            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(PISTA_04);
            System.out.println(CABECERA_PISTA + " ".repeat(posicionJugador) + CAMELLO);
            System.out.println(PISTA_04);

            System.out.println("Turno " + numerodeTurno);
            System.out.println("Jugador en la posición " + posicionJugador);
            System.out.print("Elija un agujero (1-4): ");
            int agujeroElegido = scanner.nextInt();

            int probabilidadAcierto = 0;
            int casillasAvanzadas = 0;

            if (agujeroElegido == 1) {
                probabilidadAcierto = 60;
                casillasAvanzadas = 1;
            } else if (agujeroElegido == 2) {
                probabilidadAcierto = 40;
                casillasAvanzadas = 2;
            } else if (agujeroElegido == 3) {
                probabilidadAcierto = 30;
                casillasAvanzadas = 4;
            } else if (agujeroElegido == 4) {
                probabilidadAcierto = 10;
                casillasAvanzadas = 6;
            } else {
                System.out.println("Agujero inválido. Pierdes este turno.");
                probabilidadAcierto = 0;
                casillasAvanzadas = 0;
            }

            int resultadoTirada = random.nextInt(100) + 1;
            if (resultadoTirada <= probabilidadAcierto) {
                posicionJugador += casillasAvanzadas;
                if (posicionJugador > POSICION_FINAL)
                    posicionJugador = POSICION_FINAL;
                System.out
                        .println("Avanza " + casillasAvanzadas + " casilla(s) - Está en la casilla " + posicionJugador);
                fallosConsecutivos = 0;
            } else {
                System.out.println("No avanza ninguna casilla - Está en la casilla " + posicionJugador);
                fallosConsecutivos++;
                if (fallosConsecutivos == 3) {
                    posicionJugador = 0;
                    System.out.println("Has fallado 3 veces seguidas. Regresas a la posición 0.");
                    fallosConsecutivos = 0;
                }
            }

            numerodeTurno++;
            if (posicionJugador >= POSICION_FINAL) {
                alcanzoLaMeta = true;
            }

            System.out.println();
        } while (!alcanzoLaMeta && numerodeTurno < 50);

        System.out.println("Jugador al final");
        System.out.println(PISTA_01);
        System.out.println(PISTA_02);
        System.out.println(PISTA_03);
        System.out.println(PISTA_04);
        System.out.println(CABECERA_PISTA + " ".repeat(posicionJugador) + CAMELLO);
        System.out.println(PISTA_04);
        System.out.println("El juego ha terminado en " + numerodeTurno + " turnos.");
        scanner.close();
    }
}
