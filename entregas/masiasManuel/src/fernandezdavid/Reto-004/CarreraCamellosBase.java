
```java
import java.util.Random;
import java.util.Scanner;

public class CarreraDeCamellos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int posicion = 0;
        int turno = 0;

        System.out.println("Carrera de camellos\n");

        while (posicion < 60) {
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
                    System.out.println("Agujero inválido. Intente de nuevo.");
                    continue;
                }
            }

            turno++;
            double tiro = random.nextDouble();
            if (tiro <= probabilidad) {
                posicion += avance;
                if (posicion > 60) posicion = 60;
                System.out.println("Turno " + turno + " - Avanza " + avance + " casillas - Está en la casilla " + posicion);
            } else {
                System.out.println("Turno " + turno + " - No avanza ninguna casilla - Está en la casilla " + posicion);
            }
            System.out.println();
        }

        mostrarPista(posicion);
        System.out.println("Turno " + turno + " - El juego ha terminado.");
    }

    static void mostrarPista(int posicion) {
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");
        System.out.println("---| 0.........1.........2.........3.........4.........5.........6 |");
        System.out.println("---| 0123456789012345678901234567890123456789012345678901234567890 |");
        System.out.println("---+-----------+---------+---------+---------+---------+-----------+");

        StringBuilder linea = new StringBuilder("[J]| ");
        for (int i = 0; i < 60; i++) {
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
