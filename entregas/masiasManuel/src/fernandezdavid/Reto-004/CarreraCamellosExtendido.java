
```java
import java.util.Random;
import java.util.Scanner;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int posicion = 0;
        int turno = 0;
        int fallosSeguidos = 0;
        int turnosPerdidos = 0;
        final int META = 60;
        final int MAX_TURNOS = 50;

        System.out.println("Carrera de camellos (versión extendida)\n");

        while (posicion < META && turno < MAX_TURNOS) {
            if (turnosPerdidos > 0) {
                turnosPerdidos--;
                turno++;
                System.out.println("El camello se recupera... (pierde este turno)");
                continue;
            }

            mostrarPista(posicion);
            System.out.println("Turno " + turno);
            System.out.print("Elija un agujero (1-4): ");
            int agujero = sc.nextInt();

            double probabilidad = 0;
            int avance = 0;

            switch (agujero) {
                case 1 -> { probabilidad = 0.6; avance = 1; }
                case 2 -> { probabilidad = 0.4; avance = 2; }
                case 3 -> { probabilidad = 0.3; avance = 4; }
                case 4 -> { probabilidad = 0.1; avance = 6; }
                default -> {
                    System.out.println("Agujero inválido. Intente de nuevo.\n");
                    continue;
                }
            }

            turno++;

            (Ahora el doble tropiezo)
            double tropiezo = random.nextDouble();
            if (tropiezo <= 0.1) {
                System.out.println("¡El camello tropieza! Pierde este turno y los dos siguientes.");
                turnosPerdidos = 2;
                fallosSeguidos = 0;
                System.out.println();
                continue;
            }

            double tiro = random.nextDouble();
            if (tiro <= probabilidad) {
                posicion += avance;
                if (posicion > META) posicion = META;
                System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Está en la casilla " + posicion);
                fallosSeguidos = 0;
            } else {
                System.out.println("Turno " + turno + " - No avanza ninguna casilla - Está en la casilla " + posicion);
                fallosSeguidos++;
                if (fallosSeguidos == 3) {
                    posicion = 0;
                    fallosSeguidos = 0;
                    System.out.println("¡Tres fallos seguidos! El camello vuelve a la casilla 0.");
                }
            }
            System.out.println();
        }

        mostrarPista(posicion);
        if (posicion >= META) {
            System.out.println("Turno " + turno + " - El juego ha terminado. ¡Has llegado a la meta!");
        } else {
            System.out.println("Turno " + turno + " - Has alcanzado el máximo de 50 turnos. Fin del juego.");
        }
    }

    static void mostrarPista(int posicion) {
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        StringBuilder linea = new StringBuilder("[J]| ");
        for (int i = 0; i <= 60; i++) {
            if (i == posicion) {
                linea.append(";--;'");
                break;
            } else {
                linea.append(" ");
            }
        }
        System.out.println(linea);
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
    }
}


```
