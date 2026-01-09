```java
import java.util.Random;
import java.util.Scanner;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int jugadorPos = 0;
        int ordenadorPos = 0;
        int turno = 0;
        int fallosSeguidos = 0;
        int turnosPerdidos = 0;
        final int META = 60;
        final int MAX_TURNOS = 50;

        System.out.println("Carrera de camellos - Jugador vs Ordenador\n");

        while (jugadorPos < META && ordenadorPos < META && turno < MAX_TURNOS) {
            if (turnosPerdidos > 0) {
                turnosPerdidos--;
                turno++;
                System.out.println("El camello se recupera... (pierde este turno)");
                System.out.println();
                continue;
            }

            mostrarPista(jugadorPos, ordenadorPos);
            System.out.println("Turno " + turno);
            System.out.print("Elija un agujero (1-4): ");
            int agujero = sc.nextInt();

            double probabilidad = 0;
            int avanceJugador = 0;

            switch (agujero) {
                case 1 -> { probabilidad = 0.6; avanceJugador = 1; }
                case 2 -> { probabilidad = 0.4; avanceJugador = 2; }
                case 3 -> { probabilidad = 0.3; avanceJugador = 4; }
                case 4 -> { probabilidad = 0.1; avanceJugador = 6; }
                default -> {
                    System.out.println("Agujero inválido. Intente de nuevo.\n");
                    continue;
                }
            }

            turno++;

            Probabilidad de tropiezo
            double tropiezo = random.nextDouble();
            if (tropiezo <= 0.1) {
                System.out.println("¡El camello tropieza! Pierde este turno y los dos siguientes.");
                turnosPerdidos = 2;
                fallosSeguidos = 0;
                System.out.println();
            } else {
                double tiro = random.nextDouble();
                if (tiro <= probabilidad) {
                    jugadorPos += avanceJugador;
                    if (jugadorPos > META) jugadorPos = META;
                    System.out.println("Turno " + turno + " - Avanza " + avanceJugador + " casillas - Está en la casilla " + jugadorPos);
                    fallosSeguidos = 0;
                } else {
                    System.out.println("Turno " + turno + " - No avanza ninguna casilla - Está en la casilla " + jugadorPos);
                    fallosSeguidos++;
                    if (fallosSeguidos == 3) {
                        jugadorPos = 0;
                        fallosSeguidos = 0;
                        System.out.println("¡Tres fallos seguidos! El camello vuelve a la casilla 0.");
                    }
                }
            }

            Movimiento del ordenador
            int avanceOrdenador = random.nextInt(3) + 1; // 1 a 3
            ordenadorPos += avanceOrdenador;
            if (ordenadorPos > META) ordenadorPos = META;
            System.out.println("El ordenador avanza " + avanceOrdenador + " casillas - Está en la casilla " + ordenadorPos);
            System.out.println();
        }

        mostrarPista(jugadorPos, ordenadorPos);

        if (jugadorPos >= META && ordenadorPos >= META) {
            System.out.println("Empate en el turno " + turno + "!");
        } else if (jugadorPos >= META) {
            System.out.println("¡Has ganado en el turno " + turno + "!");
        } else if (ordenadorPos >= META) {
            System.out.println("El ordenador gana en el turno " + turno + "!");
        } else {
            System.out.println("Turno " + turno + " - Se acabaron los turnos. Fin del juego.");
        }
    }

    static void mostrarPista(int jugadorPos, int ordenadorPos) {
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        // Jugador
        StringBuilder lineaJ = new StringBuilder("[J]| ");
        for (int i = 0; i <= 60; i++) {
            if (i == jugadorPos) {
                lineaJ.append(";--;'");
                break;
            } else {
                lineaJ.append(" ");
            }
        }
        System.out.println(lineaJ);
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        // Ordenador
        StringBuilder lineaO = new StringBuilder("[O]| ");
        for (int i = 0; i <= 60; i++) {
            if (i == ordenadorPos) {
                lineaO.append(";--;'");
                break;
            } else {
                lineaO.append(" ");
            }
        }
        System.out.println(lineaO);
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
    }
}

  ```
