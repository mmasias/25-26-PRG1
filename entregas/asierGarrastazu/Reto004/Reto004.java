package entregas.asierGarrastazu.Reto004;

import java.util.Random;
import java.util.Scanner;

class carrera_camello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CABECERO_PISTA = "[J]";
        final String CAMELLO = ";--;'";
        final int DISTANCIA_META = 60;

        int POSICION_CAMELLO = 0;
        int turno = 0;

        System.out.println("Jugadores a sus posiciones");

        while (POSICION_CAMELLO < DISTANCIA_META) {
            System.out.println("Turno: " + turno);
            System.out.print("Elija un agujero (1-4): ");
            int ELECCION = sc.nextInt();

            if (ELECCION < 1 || ELECCION > 4) {
                System.out.println("Elección no válida, intente de nuevo.");
                continue;
            }

            turno++;
            double PROBABILIDAD = 0.0;
            int AVANZA = 0;

            
            if (ELECCION == 1) {
                PROBABILIDAD = 0.6;
                AVANZA = 1;
            } else if (ELECCION == 2) {
                PROBABILIDAD = 0.4;
                AVANZA = 2;
            } else if (ELECCION == 3) {
                PROBABILIDAD = 0.3;
                AVANZA = 4;
            } else if (ELECCION == 4) {
                PROBABILIDAD = 0.1;
                AVANZA = 6;
            }

            double tiro = rand.nextDouble();

            if (tiro < PROBABILIDAD) {
                POSICION_CAMELLO += AVANZA;
                if (POSICION_CAMELLO > DISTANCIA_META) {
                    POSICION_CAMELLO = DISTANCIA_META;
                }
                System.out.println("Turno " + turno + " - Acierta! Avanza " + AVANZA + 
                                   " casillas - Está en la casilla " + POSICION_CAMELLO);
            } else {
                System.out.println("Turno " + turno + " - Falla! No avanza - Está en la casilla " + POSICION_CAMELLO);
            }

            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(PISTA_04);
            System.out.print(CABECERO_PISTA + "|");

            for (int i = 0; i <= DISTANCIA_META; i++) {
                if (i == POSICION_CAMELLO) {
                    System.out.print(CAMELLO);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            System.out.println(PISTA_04);
            System.out.println();
        }

        System.out.println("Turno " + turno + " - ¡El juego ha terminado! El camello llegó a la casilla " + DISTANCIA_META);
        sc.close();
    }
}