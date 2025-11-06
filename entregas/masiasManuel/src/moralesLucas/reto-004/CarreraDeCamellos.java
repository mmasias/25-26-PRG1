import java.util.Scanner;
import java.util.Random;

public class CarreraDeCamellos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        final int META = 60;
        final String PISTA_1 = "---+-----------+---------+---------+---------+---------+-----------+";
        final String PISTA_2 = "---| 0.........1.........2.........3.........4.........5.........6 |";
        final String PISTA_3 = "---| 0123456789012345678901234567890123456789012345678901234567890 |";

        int probabilidad_1 = 60, avance1 = 1;
        int probabilidad_2 = 40, avance2 = 2;
        int probabilidad_3 = 30, avance3 = 4;
        int probabilidad_4 = 10, avance4 = 6;

        int posicion = 0;
        int turno = 0;

        System.out.println("BIENVENIDO A LA CARRERA DE CAMELLOS");
        System.out.println("Llega a la casilla 60 para ganar.");
        System.out.println("--------------------------------------");
        System.out.println("Agujeros:");
        System.out.println("1 → 60% de acierto, avanza 1 casilla");
        System.out.println("2 → 40% de acierto, avanza 2 casillas");
        System.out.println("3 → 30% de acierto, avanza 4 casillas");
        System.out.println("4 → 10% de acierto, avanza 6 casillas\n");

        while (posicion < META) {
            turno++;

            System.out.println(PISTA_1);
            System.out.println(PISTA_2);
            System.out.println(PISTA_3);
            System.out.println(PISTA_1);
            mostrarCamello(posicion);
            System.out.println(PISTA_1);

            System.out.println("Turno " + turno + " - Estás en la casilla " + posicion);
            System.out.print("Elige un agujero (1-4): ");

            int eleccion = sc.nextInt();

            if (eleccion < 1 || eleccion > 4) {
                System.out.println("Número incorrecto. Debe ser entre 1 y 4.\n");
            } else {
                int tiro = random.nextInt(100) + 1; 
                int prob = 0;
                int avance = 0;

                if (eleccion == 1) {
                    prob = probabilidad_1;
                    avance = avance1;
                } else if (eleccion == 2) {
                    prob = probabilidad_2;
                    avance = avance2;
                } else if (eleccion == 3) {
                    prob = probabilidad_3;
                    avance = avance3;
                } else if (eleccion == 4) {
                    prob = probabilidad_4;
                    avance = avance4;
                }

                if (tiro <= prob) {
                    posicion = posicion + avance;
                    if (posicion > META) {
                        posicion = META;
                    }
                    System.out.println("Acierto, Avanzas " + avance + " casilla(s).\n");
                } else {
                    System.out.println("Fallaste. Te quedas en la casilla " + posicion + ".\n");
                }
            }
        }

        System.out.println(PISTA_1);
        System.out.println(PISTA_2);
        System.out.println(PISTA_3);
        System.out.println(PISTA_1);
        mostrarCamello(META);
        System.out.println(PISTA_1);
        System.out.println("Has llegado a la meta en " + turno + " turnos");
        sc.close();
    }

    public static void mostrarCamello(int posicion) {
        System.out.print("[J]|");
        for (int i = 0; i < posicion; i++) {
            System.out.print(" ");
        }
        System.out.println(";--;'");
    }
}
