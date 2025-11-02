package entregas.sanmiguelHector.ejercicios;
import java.util.Scanner;
import java.util.Random;

public class WhacaMole {
    public static void main(String[] args) {

        final String AGUJERO = "(  )";
        final String AGUJERO_CON_MONIGOTE = "('')";
        final String AGUJERO_GOLPEADO = "([])";
        final String AGUJERO_CON_MONIGOTE_GOLPEADO = "[**]";

        Random random = new Random();

        int filaPensadaPorOrdenador = random.nextInt(4) + 1;
        int columnaPensadaPorOrdenador = random.nextInt(4) + 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué fila quieres golpear? (1-4)");
        int filaSeleccionada = scanner.nextInt();
        System.out.println("¿Qué columna quieres golpear? (1-4)");
        int columnaSeleccionada = scanner.nextInt();

        System.out.println("Tablero resultante:");

        for (int fila = 1; fila <= 4; fila++) {
            for (int columna = 1; columna <= 4; columna++) {

                if (fila == filaPensadaPorOrdenador && columna == columnaPensadaPorOrdenador) {
                    if (fila == filaSeleccionada && columna == columnaSeleccionada) {
                        System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);
                    } else {
                        System.out.print(AGUJERO_CON_MONIGOTE);
                    }
                } else {
                    if (fila == filaSeleccionada && columna == columnaSeleccionada) {
                        System.out.print(AGUJERO_GOLPEADO);
                    } else {
                        System.out.print(AGUJERO);
                    }
                }

            }
            System.out.println();
        }
        scanner.close();
    }
}