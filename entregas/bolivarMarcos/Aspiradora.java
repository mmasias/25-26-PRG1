package entregas.bolivarMarcos;
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
        int[] posicionGato = { 2, 2 };

        ensuciarEscenario(superficie);

        do {
            moverAspiradora(posicionAspiradora, superficie);
            moverGato(posicionGato, superficie);
            imprimirEscenario(superficie, posicionAspiradora, posicionGato);
            limpiar(superficie, posicionAspiradora);
            ensuciar(superficie, posicionGato, posicionAspiradora);
            new Scanner(System.in).nextLine();
        } while (estaSucia(superficie));
    }

    static boolean estaSucia(int[][] superficie){
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                 if(superficie[i][j]>0){
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

    static void ensuciar(int[][] superficie, int[] gato, int[] aspiradora) {

        if ((gato[0] != aspiradora[0] || gato[1] != aspiradora[1]) && superficie[gato[0]][gato[1]] < 4) {
            superficie[gato[0]][gato[1]] = superficie[gato[0]][gato[1]] + 1;
        }
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
        return posicionAlgo[0] >= 0 && posicionAlgo[0] < superficie.length
                && posicionAlgo[1] >= 0 && posicionAlgo[1] < superficie[0].length;
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

                if (row == posicionAspiradora[0] && column == posicionAspiradora[1] 
                    && row == posicionGato[0] && column == posicionGato[1]) {
                    System.out.print(mapearCombinado());
                } else if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } else if (row == posicionGato[0] && column == posicionGato[1]) {
                    System.out.print(mapearGato());
                } else {
                    int elTile = superficie[row][column];
                    System.out.print(mapear(elTile));
                }
            }
            System.out.println("|");
        }
        System.out.println(elBorde);
    }

    static String imprimeBordeHorizontal(int length) {
        return "+" + "===".repeat(length) + "+";
    }

    static String mapearAspiradora() {
        return "(O)";
    }

    static String mapearGato() {
        return "^w^";
    }

    static String mapearCombinado() {
        return "(^o^)";
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