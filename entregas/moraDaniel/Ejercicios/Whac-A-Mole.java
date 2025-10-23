package entregas.moraDaniel.Ejercicios;

import java.util.Random;
import java.util.Scanner;

class WhacAMole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final String AGUJERO = "(  )";
        final String MONIGOTE = "(‘‘)";
        final String MARTILLO = "[[]]";
        final String MONIGOTE_GOLPEADO = "[**]";

        final int DIMENSION = 4;
        final int NUMERO_CASILLAS = DIMENSION * DIMENSION;
        final int TURNOS = 15;

        int aciertos = 0;
        int ultimoPosicionMonigote = -1;

        System.out.println("   WHAC-A-MOLE   ");
        System.out.println("Tablero: " + DIMENSION + " x " + DIMENSION + " (" + NUMERO_CASILLAS + " agujeros)");
        System.out.println(
                "Tienes " + TURNOS + " turnos. Introduce números entre 1 y " + NUMERO_CASILLAS);

        for (int turno = 1; turno <= TURNOS; turno++) {

            int posicionMonigote;
            do {
                posicionMonigote = random.nextInt(NUMERO_CASILLAS) + 1;
            } while (posicionMonigote == ultimoPosicionMonigote && NUMERO_CASILLAS > 1);
            ultimoPosicionMonigote = posicionMonigote;

            int posicionGolpe = 0;
            while (true) {
                System.out.print("Turno " + turno + " - ¿Dónde golpeas (1-" + NUMERO_CASILLAS + ")? ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada no válida. Introduce un número entre 1 y " + NUMERO_CASILLAS + ".");
                    scanner.next();
                    continue;
                }
                posicionGolpe = scanner.nextInt();
                if (posicionGolpe < 1 || posicionGolpe > NUMERO_CASILLAS) {
                    System.out.println("Número fuera de rango. Intenta de nuevo.");
                    continue;
                }
                break;
            }

            boolean acierto = (posicionGolpe == posicionMonigote);
            if (acierto) {
                aciertos++;
            }

            for (int i = 1; i <= NUMERO_CASILLAS; i++) {
                if (i == posicionMonigote && i == posicionGolpe) {

                    System.out.print(MONIGOTE_GOLPEADO + " ");
                } else if (i == posicionMonigote) {

                    System.out.print(MONIGOTE + " ");
                } else if (i == posicionGolpe) {

                    System.out.print(MARTILLO + " ");
                } else {
                    System.out.print(AGUJERO + " ");
                }

                if (i % DIMENSION == 0) {
                    System.out.println();
                }
            }

            if (acierto) {
                System.out.println("¡Acierto! Has golpeado al monigote.");
            } else {
                System.out.println("Fallaste. El monigote estaba en la casilla " + posicionMonigote + ".");
            }
            System.out.println();
        }

        System.out.println("Fin del juego. Aciertos totales: " + aciertos + " de " + TURNOS + ".");
        scanner.close();
    }
}
