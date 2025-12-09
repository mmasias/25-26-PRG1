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
        int[] poscicionGato = { 4, 4 };
        int[][] actores = { posicionAspiradora, poscicionGato };

        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);;

        do {
            mover(actores, superficie);
            imprimirEscenario(superficie, actores);
            afectar(superficie, actores);
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

    static void afectar(int[][] superficie, int[][] actores) {
        limpiar(superficie, actores[0]);
        ensuciar(superficie, actores[1]);
    }

    static void limpiar(int[][] superficie, int[] aspiradora) {

        if (estaSucio(superficie[aspiradora[0]][aspiradora[1]])) {
            superficie[aspiradora[0]][aspiradora[1]] = superficie[aspiradora[0]][aspiradora[1]] - 1;
        }
    }

    static void ensuciar(int[][] superficie, int[] gato) {

       if(superficie[gato[0]][gato[1]] < 4) {
        superficie[gato[0]][gato[1]] = superficie[gato[0]][gato[1]] + 1;
       }
    }

    static boolean estaSucio(int tile) {
        return tile > 0;
    }

    static void mover(int[][] actores, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoAspiradoraX = (int) (Math.random() * 3) - 1;
        int movimientoAspiradoraY = (int) (Math.random() * 3) - 1;

        actores[0][X] = actores[0][X] + movimientoAspiradoraX;
        actores[0][Y] = actores[0][Y] + movimientoAspiradoraY;

        if (!posicionValida(actores[0], superficie)) {
            actores[0][X] = actores[0][X] - movimientoAspiradoraX;
            actores[0][Y] = actores[0][Y] - movimientoAspiradoraY;
        }

                int movimientoGatoX = (int) (Math.random() * 3) - 1;
        int movimientoGatoY = (int) (Math.random() * 3) - 1;

        actores[1][X] = actores[1][X] + movimientoGatoX;
        actores[1][Y] = actores[1][Y] + movimientoGatoY;

        if (!posicionValida(actores[1], superficie)) {
            actores[1][X] = actores[1][X] - movimientoGatoX;
            actores[1][Y] = actores[1][Y] - movimientoGatoY;
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

    static void imprimirEscenario(int[][] superficie, int[][] actores) {
        String elBorde = imprimeBordeHorizontal(superficie[0].length);
        System.out.println(elBorde);

        for (int row = 0; row < superficie.length; row++) {
            System.out.print("|");
            for (int column = 0; column < superficie[row].length; column++) {

                if (row == actores[0][0] && column == actores[0][1]) {
                    System.out.print(mapearAspiradora());
                } else if (row == actores[1][0] && column == actores[1][1]) {
                    System.out.print(mapearGato());
                } else {
                    int elTile = superficie[row][column];
                    System.out.print(mapear(elTile));
                }
            }
            System.out.println("|");
        }
        System.out.println(elBorde);

        if (actores[0][0] == actores[1][0] && actores[0][1] == actores[1][1]) {
            System.out.println("¡MMMEEEEEEOOOOOOOOOOOOOOOOOOOWWW!");
        }
    }

    static String imprimeBordeHorizontal(int length) {
        return "+" + "===".repeat(length) + "+";
    }

    static String mapearAspiradora() {
        return "(O)";
    }

    static String mapearGato() {
        return "^=^";
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