import java.util.Random;
import java.util.Scanner;

public class CarreraCamellosBase {

    private static final int META = 60;
    private static final int ANCHO_TABLERO = 70;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        int posicion = 0;
        int turnos = 0;

        System.out.println("Bienvenido a la Carrera de Camellos (Versión Visual) \n");

        mostrarTablero(posicion, "Jugador al inicio", ";--;'");

        while (posicion < META) {
            System.out.println("Turno " + turnos);
            System.out.print("Elija un agujero (1-4): ");
            int agujero = entrada.nextInt();

            if (agujero < 1 || agujero > 4) {
                System.out.println("Agujero no válido. Intente de nuevo.\n");
                continue;
            }

            turnos++;

            int probabilidad = obtenerProbabilidad(agujero);
            int avance = obtenerAvance(agujero);

            boolean acierta = acierto(probabilidad, random);
            int posicionAnterior = posicion;

            if (acierta) {
                posicion += avance;
                if (posicion > META) posicion = META;
                System.out.println("Acierto: Avanza " + avance + " casilla(s).");
            } else {
                System.out.println("Fallo: No avanza.");
            }

           if (posicion >= META) {
                mostrarTablero(posicion, "Jugador al final", ";--;'");
            } else {
                if (acierta) {
                    mostrarTablero(posicion, "Jugador en la posición " + posicion, ";--;'");
                    System.out.println("Turno " + turnos + " - Avanza " + avance + 
                                       " casilla(s) - Está en la casilla " + posicion + "\n");
                } else {
                    mostrarTablero(posicion, "Jugador en la posición " + posicion + " y sin acertar", ";--;'");
                    System.out.println("Turno " + turnos + " - No avanza ninguna casilla - Está en la casilla " + posicion + "\n");
                }
            }
        }

        System.out.println("El juego ha terminado. Has llegado a la meta en " + turnos + " turnos.");
        entrada.close();
    }

    public static void mostrarTablero(int posicion, String titulo, String figura) {
        System.out.println(titulo);
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        int espacios = Math.min(posicion, ANCHO_TABLERO - 1);
        System.out.print("[J]| ");
        for (int i = 0; i < espacios; i++) {
            System.out.print(" ");
        }
        System.out.println(figura);

        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
    }

    public static int obtenerProbabilidad(int agujero) {
        switch (agujero) {
            case 1: return 60;
            case 2: return 40;
            case 3: return 30;
            case 4: return 10;
            default: return 0;
        }
    }

    public static int obtenerAvance(int agujero) {
        switch (agujero) {
            case 1: return 1;
            case 2: return 2;
            case 3: return 4;
            case 4: return 6;
            default: return 0;
        }
    }

    public static boolean acierto(int probabilidad, Random random) {
        int numero = random.nextInt(100) + 1; // número entre 1 y 100
        return numero <= probabilidad;
    }
}
