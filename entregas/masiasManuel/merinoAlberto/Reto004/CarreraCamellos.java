import java.util.Scanner;

public class CarreraCamellos {
    public static void main(String[] args) {


        final String TABLERO_ARRIBA = "---+-----------+---------+---------+---------+---------+-----------+";
        final String TABLERO_NUMEROS1 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String TABLERO_NUMEROS2 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";
        final String CABALLO = ";--;'";
        final String JUGADOR = "[J]| ";

        Scanner scanner = new Scanner(System.in);

        int posicion = 0;
        int turno = 0;
        int agujero;
        double probabilidad;
        int avance;

        while (posicion < 60) {

            System.out.println(TABLERO_ARRIBA);
            System.out.println(TABLERO_NUMEROS1);
            System.out.println(TABLERO_NUMEROS2);
            System.out.println(TABLERO_ARRIBA);

            System.out.print(JUGADOR);
            for (int i = 0; i < posicion; i = i + 1) {
                System.out.print(" ");
            }
            System.out.println(CABALLO);
            System.out.println(TABLERO_ARRIBA);

            System.out.println("Turno " + turno);
            System.out.print("Elija un agujero (1-4): ");
            agujero = scanner.nextInt();

            if (agujero < 1 || agujero > 4) {
                System.out.println("Agujero no válido. Intente de nuevo.");
                continue;
            }

            turno = turno + 1;
            avance = 0;
            probabilidad = Math.random();

            if (agujero == 1) {
                if (probabilidad <= 0.6) {
                    avance = 1;
                }
            } else if (agujero == 2) {
                if (probabilidad <= 0.4) {
                    avance = 2;
                }
            } else if (agujero == 3) {
                if (probabilidad <= 0.3) {
                    avance = 4;
                }
            } else if (agujero == 4) {
                if (probabilidad <= 0.1) {
                    avance = 6;
                }
            }

            if (avance > 0) {
                posicion = posicion + avance;
                if (posicion > 60) {
                    posicion = 60;
                }
                System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Está en la casilla " + posicion);
            } else {
                System.out.println("Turno " + turno + " - No avanza ninguna casilla - Está en la casilla " + posicion);
            }

        }

        System.out.println(TABLERO_ARRIBA);
        System.out.println(TABLERO_NUMEROS1);
        System.out.println(TABLERO_NUMEROS2);
        System.out.println(TABLERO_ARRIBA);
        System.out.print(JUGADOR);
        for (int i = 0; i < posicion; i = i + 1) {
            System.out.print(" ");
        }
        System.out.println(CABALLO);
        System.out.println(TABLERO_ARRIBA);
        System.out.println("Turno " + turno + " - Ha llegado a la casilla 60");
        System.out.println("El juego termino");
    }
}
