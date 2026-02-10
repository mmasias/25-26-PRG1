
import java.util.Scanner;

public class Aspiradora {

    public static void main(String[] args) {

        int[][] superficie = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        int[] posicionAspiradora = { 4, 4 };
        int[] posicionGato = { 4, 4 };

        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);
        ;

        do {
            imprimirEscenario(superficie, posicionAspiradora, posicionGato);
            moverAspiradora(posicionAspiradora, superficie);
            moverGato(posicionGato, superficie);
            ensuciar(superficie, posicionGato);
            limpiar(superficie, posicionAspiradora);
            hayQueLimpiar = estaSucia(superficie);
            new Scanner(System.in).nextLine();
        } while (hayQueLimpiar);
    }

    static boolean estaSucia(int[][] superficie) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                if (superficie[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static void limpiar(int[][] superficie, int[] aspiradora) {

        if (estaSucio(superficie[aspiradora[0]][aspiradora[1]])) {
            superficie[aspiradora[0]][aspiradora[1]] = superficie[aspiradora[0]][aspiradora[1]] - 1;
        }
    }

    static void ensuciar(int[][] superficie, int[] Gato) {

        if (puedeEnsuciar(superficie[Gato[0]][Gato[1]])) {
            superficie[Gato[0]][Gato[1]] = superficie[Gato[0]][Gato[1]] + 1;
        }
    }

    static boolean puedeEnsuciar(int tile) {
        return tile < 4;
    }

    static boolean estaSucio(int tile) {
        return tile > 0;
    }

    static void moverAspiradora(int[] posicionAspiradora, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicionAspiradora[X] = posicionAspiradora[X] + movimientoX;
        posicionAspiradora[Y] = posicionAspiradora[Y] + movimientoY;

        if (!posicionValida(posicionAspiradora, superficie)) {
            posicionAspiradora[X] = posicionAspiradora[X] - movimientoX;
            posicionAspiradora[Y] = posicionAspiradora[Y] - movimientoY;
        }
    }

    static void moverGato(int[] posicionGato, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicionGato[X] = posicionGato[X] + movimientoX;
        posicionGato[Y] = posicionGato[Y] + movimientoY;

        if (!posicionValida(posicionGato, superficie)) {
            posicionGato[X] = posicionGato[X] - movimientoX;
            posicionGato[Y] = posicionGato[Y] - movimientoY;
        }
    }

    static boolean posicionValida(int[] posicionAlgo, int[][] superficie) {
        int y = posicionAlgo[0];
        int x = posicionAlgo[1];

        return y >= 0 && y < superficie.length && x >= 0 && x < superficie[y].length;
    }

    static void ensuciarEscenario(int[][] superficie) {

        for (int row = 0; row < superficie.length; row++) {
            for (int column = 0; column < superficie[row].length; column++) {
                superficie[row][column] = (int) (Math.random() * 5);
            }
        }
    }

    static void imprimirEscenario(int[][] superficie, int[] posicionAspiradora, int[] posicionGato) {
        String elBorde = imprimeBordeHorizontal(superficie[0].length);
        System.out.println(elBorde);

        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {
                if (row == posicionGato[0] && column == posicionGato[1] &&
                        row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print("(G)");
                } else if (row == posicionGato[0] && column == posicionGato[1]) {
                    System.out.print(mapearGato());
                } else if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } else {
                    int elTile = superficie[row][column];
                    System.out.print(mapear(elTile));
                }

            }
            System.out.println("|");

        }
        System.out.println(elBorde);
        if (posicionGato[0] == posicionAspiradora[0] && posicionGato[1] == posicionAspiradora[1]) {
            System.out.print("MIAUOOO");
        }
    }

    static String imprimeBordeHorizontal(int length) {
        return "+" + "===".repeat(length) + "+";
    } 

    static String mapearAspiradora() {
        return "(O)";
    }

    static String mapearGato() {
        return "GGG";
    }

    static String mapear(int tile) {

        String[] estadosSuciedad = {
                " . ",
                "...",
                "ooo",
                "OOO",
                "***"
        };
        return estadosSuciedad[tile];
    }

}
