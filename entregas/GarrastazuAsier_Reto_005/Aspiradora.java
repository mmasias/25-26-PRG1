

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
        boolean hayQueLimpiar = estaSucia(superficie);

        Scanner scanner = new Scanner(System.in);

        do {
            moverAspiradora(posicionAspiradora, superficie);
            limpiar(superficie, posicionAspiradora);

            moverGato(posicionGato, superficie);
            ensuciarGato(superficie, posicionGato);

            imprimirEscenario(superficie, posicionAspiradora, posicionGato);

            hayQueLimpiar = estaSucia(superficie);
            scanner.nextLine();

        } while (hayQueLimpiar);

        scanner.close();
    }



    static boolean estaSucia(int[][] superficie){
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                if(superficie[i][j] > 0){
                    return true;
                }
            }
        }
        return false;
    }

    static void limpiar(int[][] superficie, int[] aspiradora) {
        if (superficie[aspiradora[0]][aspiradora[1]] > 0) {
            superficie[aspiradora[0]][aspiradora[1]]--;
        }
    }

    static void moverAspiradora(int[] posicion, int[][] superficie) {
        moverAleatorio(posicion, superficie);
    }


    static void moverGato(int[] posicion, int[][] superficie) {
        moverAleatorio(posicion, superficie);
    }

    static void ensuciarGato(int[][] superficie, int[] gato) {
        int fila = gato[0];
        int columna = gato[1];


        if (superficie[fila][columna] < 4) {
            superficie[fila][columna]++;
        }
    }

    static void moverAleatorio(int[] posicion, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicion[X] += movimientoX;
        posicion[Y] += movimientoY;

        if (!posicionValida(posicion, superficie)) {
            posicion[X] -= movimientoX;
            posicion[Y] -= movimientoY;
        }
    }

    static boolean posicionValida(int[] pos, int[][] superficie) {
        return pos[0] >= 0 && pos[0] < superficie.length
                && pos[1] >= 0 && pos[1] < superficie[0].length;
    }

    static void ensuciarEscenario(int[][] superficie) {
        for (int row = 0; row < superficie.length; row++) {
            for (int column = 0; column < superficie[row].length; column++) {
                superficie[row][column] = (int) (Math.random() * 5);
            }
        }
    }

    static void imprimirEscenario(int[][] superficie, int[] aspiradora, int[] gato) {

        String elBorde = imprimeBordeHorizontal(superficie[0].length);
        System.out.println(elBorde);

        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {

                if (row == aspiradora[0] && column == aspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } 
                else if (row == gato[0] && column == gato[1]) {
                    System.out.print(mapearGato());
                }
                else {
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
        return "(G)";
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