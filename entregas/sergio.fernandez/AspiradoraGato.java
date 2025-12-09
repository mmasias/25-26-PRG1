import java.util.Scanner;

public class AspiradoraGato {

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
        int[] posicionGato = { 3, 5 };

        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);

        do {
            moverAgente(posicionGato, superficie);
            ensuciarPorGato(superficie, posicionGato);

            moverAgente(posicionAspiradora, superficie);
            limpiar(superficie, posicionAspiradora);

            imprimirEscenario(superficie, posicionAspiradora, posicionGato);
            hayQueLimpiar = estaSucia(superficie);
            new Scanner(System.in).nextLine();
        } while (hayQueLimpiar);
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

    static boolean estaSucio(int tile) {
        return tile > 0;
    }

    static void moverAgente(int[] posicionAgente, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicionAgente[X] = posicionAgente[X] + movimientoX;
        posicionAgente[Y] = posicionAgente[Y] + movimientoY;

        if (!posicionValida(posicionAgente, superficie)) {
            posicionAgente[X] = posicionAgente[X] - movimientoX;
            posicionAgente[Y] = posicionAgente[Y] - movimientoY;
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

                boolean esAspiradora = (row == posicionAspiradora[0] && column == posicionAspiradora[1]);
                boolean esGato = (row == posicionGato[0] && column == posicionGato[1]);

                if (esAspiradora && esGato) {
                    System.out.print("(3)");
                } else if (esAspiradora) {
                    System.out.print(mapearAspiradora());
                } else if (esGato) {
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

    static void ensuciarPorGato(int[][] superficie, int[] gato) {
        final int MAX_DIRT = 4;


        if (superficie[gato[0]][gato[1]] < MAX_DIRT) {
            superficie[gato[0]][gato[1]] = superficie[gato[0]][gato[1]] + 1;
        }
    }

    static String mapearGato() {
        return " :3";
    }

}
