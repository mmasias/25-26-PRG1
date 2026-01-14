import java.util.Scanner;

public class WhacAmoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String AGUJERO = "(  )";
        final String AGUJERO_MONIGOTE = "($$)";
        final String AGUJERO_GOLPEADO = "[[]]";
        final String AGUJERO_MONIGOTE_GOLPEADO = "[**]";

        final int INTENTOS_MAXIMOS = 15;
        final int DIMENSION = 4;
        final int NUMERO_CASILLAS = DIMENSION * DIMENSION;

        int numeroDeIntentos = 0;
        int posicionImpresion = 0;
        int numeroAciertos = 0;

        while (numeroDeIntentos < INTENTOS_MAXIMOS) {
            int posicionGolpeada;
            do {
                System.out.println("que posicion eliges para golper entre 1 y " + NUMERO_CASILLAS + "?");
                 posicionGolpeada = scanner.nextInt();
                if (posicionGolpeada < 1 || posicionGolpeada > NUMERO_CASILLAS) {
                    System.out.println("Valor inválido. Intentalo de nuevo.");
                }

            } while (posicionGolpeada < 1 || posicionGolpeada > NUMERO_CASILLAS);

            int posicionMonigote = (int) (Math.random() * NUMERO_CASILLAS) + 1;
            posicionImpresion = 0;
            boolean monigoteGolpeado = false;

            numeroDeIntentos++;
            for (int filas = 1; filas <= DIMENSION; filas++) {
                for (int columnas = 1; columnas <= DIMENSION; columnas++) {
                    posicionImpresion++;
                    if (posicionImpresion == posicionMonigote && posicionGolpeada == posicionMonigote) {
                        System.out.print(AGUJERO_MONIGOTE_GOLPEADO);
                        monigoteGolpeado = true;
                    } else if (posicionImpresion == posicionMonigote) {
                        System.out.print(AGUJERO_MONIGOTE);
                    } else if (posicionImpresion == posicionGolpeada) {
                        System.out.print(AGUJERO_GOLPEADO);
                    } else {
                        System.out.print(AGUJERO);
                    }
                }
                System.out.println();
            }
            if (monigoteGolpeado) {
                numeroAciertos++;
                System.out.println("!ACERTASTE¡");

            } else {
                System.out.println("¡FALLASTE!");
            }
        }
        System.out.println("has acertado un total de veces de " + numeroAciertos);

    }
}
