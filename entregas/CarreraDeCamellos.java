import java.util.Scanner;

public class CarreraDeCamellos {

    public static void main(String[] args) {

        final String PISTA_01 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_02 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_03 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String PISTA_04 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String CAMELLO = ";--;'";

        Scanner scanner = new Scanner(System.in);

        int numeroTurnos = 0;
        int posicion = 0;
        final int META = 60;

        System.out.println("¡Bienvenido a la carrera de camellos!");
        System.out.println("Llega a la casilla 60 para ganar.");

        System.out.println(PISTA_01);
        System.out.println(PISTA_02);
        System.out.println(PISTA_03);
        System.out.println(PISTA_04);
        System.out.println("[J]|" + CAMELLO + " ".repeat(META - 1) + "|");
        System.out.println(PISTA_04);

        while (posicion < META) {
            numeroTurnos = numeroTurnos + 1;

            System.out.println("Turno " + numeroTurnos);
            System.out.print("Elige un agujero (1, 2, 3 o 4): ");
            int agujero = scanner.nextInt();

            if (agujero < 1 || agujero > 4) {
                System.out.println("Opción inválida. Elige un número entre 1 y 4.");
                continue;
            }

            int avance = 0;
            boolean acierto = false;
            double probabilidad = Math.random();

            if (agujero == 1) {
                if (probabilidad < 0.6) {
                    acierto = true; avance = 1;
                }
            } else if (agujero == 2) {
                if (probabilidad < 0.4) {
                    acierto = true; avance = 2;
                }
            } else if (agujero == 3) {
                if (probabilidad < 0.3) {
                    acierto = true; avance = 4;
                }
            } else if (agujero == 4) {
                if (probabilidad < 0.1) {
                    acierto = true; avance = 6;
                }
            }

            if (acierto) {
                posicion = posicion + avance;
                if (posicion > META) posicion = META;
                System.out.println("¡ACERTASTE! Avanzas " + avance + " casillas. Estás en la casilla " + posicion);
            } else {
                System.out.println("HAS FALLADO. Sigues en la casilla " + posicion);
            }

            System.out.println();
            System.out.println(PISTA_01);
            System.out.println(PISTA_02);
            System.out.println(PISTA_03);
            System.out.println(PISTA_04);
            System.out.print("[J]|");

            for (int casilla = 0; casilla < posicion; casilla = casilla + 1) {
                System.out.print(" ");
            }
            System.out.print(CAMELLO);
            for (int i_posicion = posicion + CAMELLO.length(); i_posicion < META; i_posicion = i_posicion + 1) {
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println(PISTA_04);
        }

        System.out.println(" ¡Has llegado a la meta en " + numeroTurnos + " turnos!");
        scanner.close();
    }
}

