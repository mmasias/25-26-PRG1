import java.util.Random;
import java.util.Scanner;

public class CarreraCamellosAmpliado {

    private static final int META = 60;
    private static final int ANCHO_TABLERO = 70;
    private static final int MAX_TURNOS = 50;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Random random = new Random();

        int posicionJugador = 0;
        int posicionOrdenador = 0;
        int turnos = 0;
        int fallosConsecutivos = 0;
        int turnosPerdidos = 0;

        System.out.println("Bienvenido a la Carrera de Camellos \n");
        mostrarTablero(posicionJugador, posicionOrdenador, "Inicio de la carrera", ";--;'");

        while (posicionJugador < META && posicionOrdenador < META && turnos < MAX_TURNOS) {

            if (turnosPerdidos > 0) {
                turnos++;
                turnosPerdidos--;
                System.out.println("El jugador está recuperándose del tropiezo (" + turnosPerdidos + " turno(s) restante).");
                avanzarOrdenador(random, posicionOrdenador);
                posicionOrdenador += random.nextInt(3) + 1;
                if (posicionOrdenador > META) posicionOrdenador = META;
                System.out.println("El ordenador avanza este turno.\n");
                continue;
            }

            System.out.println("Turno " + turnos);
            System.out.print("Elija un agujero (1-4): ");
            int agujero = entrada.nextInt();

            if (agujero < 1 || agujero > 4) {
                System.out.println("Agujero no válido. Intente de nuevo.\n");
                continue;
            }

            turnos++;

            if (random.nextInt(100) < 10) {
                System.out.println("¡El camello tropieza! Pierdes este turno y los dos siguientes.");
                turnosPerdidos = 2;
                mostrarTablero(posicionJugador, posicionOrdenador,
                        "Jugador tropieza, ordenador se mueve...", ";--;'");

                int avanceOrdenador = random.nextInt(3) + 1;
                posicionOrdenador += avanceOrdenador;
                if (posicionOrdenador > META) posicionOrdenador = META;
                System.out.println("El ordenador avanza " + avanceOrdenador + " casilla(s).");
                continue;
            }

            int probabilidad = obtenerProbabilidad(agujero);
            int avanceJugador = obtenerAvance(agujero);
            boolean acierta = acierto(probabilidad, random);

            if (acierta) {
                posicionJugador += avanceJugador;
                if (posicionJugador > META) posicionJugador = META;
                System.out.println("Acierto: Avanza " + avanceJugador + " casilla(s).");
                fallosConsecutivos = 0; // reiniciar contador de fallos
            } else {
                fallosConsecutivos++;
                System.out.println("Fallo número " + fallosConsecutivos + ".");
                if (fallosConsecutivos == 3) {
                    posicionJugador = 0;
                    System.out.println("Tres fallos seguidos: vuelves a la posición 0.");
                    fallosConsecutivos = 0;
                }
            }

            int avanceOrdenador = random.nextInt(3) + 1;
            posicionOrdenador += avanceOrdenador;
            if (posicionOrdenador > META) posicionOrdenador = META;

            mostrarTablero(posicionJugador, posicionOrdenador,
                    "Jugador en " + posicionJugador + ", ordenador en " + posicionOrdenador, ";--;\'");

            if (acierta) {
                System.out.println("Turno " + turnos + " - Avanza " + avanceJugador +
                        " casilla(s) - Está en la casilla " + posicionJugador);
            } else {
                System.out.println("Turno " + turnos + " - No avanza ninguna casilla - Está en la casilla " + posicionJugador);
            }
            System.out.println("El ordenador avanza " + avanceOrdenador +
                    " casilla(s) - Está en la casilla " + posicionOrdenador + "\n");
        }

        System.out.println("Fin del juego");
        System.out.println("Jugador en casilla " + posicionJugador);
        System.out.println("Ordenador en casilla " + posicionOrdenador);
        System.out.println("Turnos totales: " + turnos);

        if (posicionJugador >= META && posicionOrdenador >= META) {
            System.out.println("¡Empate técnico! Ambos llegaron a la meta.");
        } else if (posicionJugador >= META) {
            System.out.println("¡El jugador gana la carrera!");
        } else if (posicionOrdenador >= META) {
            System.out.println("¡El ordenador gana la carrera!");
        } else {
            if (posicionJugador > posicionOrdenador) {
                System.out.println("Se acabaron los turnos: gana el jugador por distancia.");
            } else if (posicionJugador < posicionOrdenador) {
                System.out.println("Se acabaron los turnos: gana el ordenador por distancia.");
            } else {
                System.out.println("Se acabaron los turnos: empate en distancia.");
            }
        }

        entrada.close();
    }

    public static void mostrarTablero(int posJugador, int posOrdenador, String titulo, String figura) {
        System.out.println(titulo);
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        int espacioJugador = Math.min(posJugador, ANCHO_TABLERO - 1);
        System.out.print("[J]| ");
        for (int i = 0; i < espacioJugador; i++) System.out.print(" ");
        System.out.println(figura);

        int espacioOrdenador = Math.min(posOrdenador, ANCHO_TABLERO - 1);
        System.out.print("[O]| ");
        for (int i = 0; i < espacioOrdenador; i++) System.out.print(" ");
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
        int numero = random.nextInt(100) + 1; // 1–100
        return numero <= probabilidad;
    }

    public static void avanzarOrdenador(Random random, int posicion) {
        int avance = random.nextInt(3) + 1;
        posicion += avance;
        if (posicion > META) posicion = META;
    }
}
