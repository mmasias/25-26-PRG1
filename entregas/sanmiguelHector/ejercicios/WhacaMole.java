package entregas.sanmiguelHector.ejercicios;
import java.util.Scanner;
import java.util.Random;

public class WhacaMole {
    public static void main(String[] args) {

        final String AGUJERO = "(  )";
        final String AGUJERO_CON_MONIGOTE = "('')";
        final String AGUJERO_GOLPEADO = "([])";
        final String AGUJERO_CON_MONIGOTE_GOLPEADO = "[**]";
        final String MENSAJE_VICTORIA = "Golpeaste a un topo!";
        final String MENSAJE_DERROTA = "No le diste a nadie";

        Random random = new Random();

        int filaTopo1 = random.nextInt(4) + 1;
        int columnaTopo1 = random.nextInt(4) + 1;
        int filaTopo2 = random.nextInt(4) + 1;
        int columnaTopo2 = random.nextInt(4) + 1;

        while (filaTopo1 == filaTopo2 && columnaTopo1 == columnaTopo2) {
            filaTopo2 = random.nextInt(4) + 1;
            columnaTopo2 = random.nextInt(4) + 1;
        }

        Scanner scanner = new Scanner(System.in);

        boolean topoGolpeado = false;

        System.out.println("¿Qué fila quieres golpear? (1-4)");
        int filaSeleccionada = scanner.nextInt();
        System.out.println("¿Qué columna quieres golpear? (1-4)");
        int columnaSeleccionada = scanner.nextInt();

        System.out.println("Tablero resultante:");

        for (int fila = 1; fila <= 4; fila++) {
            for (int columna = 1; columna <= 4; columna++) {

                if ((fila == filaTopo1 && columna == columnaTopo1) || (fila == filaTopo2 && columna == columnaTopo2)) {
                    if (fila == filaSeleccionada && columna == columnaSeleccionada) {
                        System.out.print(AGUJERO_CON_MONIGOTE_GOLPEADO);
                        topoGolpeado = true;
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
        
        if (topoGolpeado){
            System.out.println(MENSAJE_VICTORIA);
        } else {
            System.out.print(MENSAJE_DERROTA);
        }
        scanner.close();
    }
}