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
        int[] posicionGato = {3,3};
        ensuciarEscenario(superficie);
        boolean hayQueLimpiar = estaSucia(superficie);;

        do {
            moverObjeto(posicionGato, superficie);
            moverObjeto(posicionAspiradora, superficie);
            imprimirEscenario(superficie, posicionAspiradora, posicionGato);
            limpiar(superficie, posicionAspiradora);
            ensuciar(superficie, posicionGato);
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

    static void ensuciar(int[][] superficie, int[] gato) {
        if (!estaMaximoSucio(superficie[gato[0]][gato[1]])) {
            superficie[gato[0]][gato[1]] = superficie[gato[0]][gato[1]] + 1;
        }
    }

    static boolean estaSucio(int tile) {
        return tile > 0;
    }
    static boolean estaMaximoSucio(int tile) {
        return tile ==4;
    } 


    static void moverObjeto(int[] posicionObjeto, int[][] superficie) {
        final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicionObjeto[X] = posicionObjeto[X] + movimientoX;
        posicionObjeto[Y] = posicionObjeto[Y] + movimientoY;

        if (!posicionValida(posicionObjeto, superficie)) {
            posicionObjeto[X] = posicionObjeto[X] - movimientoX;
            posicionObjeto[Y] = posicionObjeto[Y] - movimientoY;
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

                if (row == posicionAspiradora[0] && column == posicionAspiradora[1]) {
                    if(posicionAspiradora[0] == posicionGato[0] && posicionAspiradora[1] == posicionGato[1] ){
                        System.out.print(mapearGatoEnAspiradora());
                    }
                    else {
                        System.out.print(mapearAspiradora());
                    }
                }
                else if (row == posicionGato[0] && column == posicionGato[1]){
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
        return "-Ɛ3";
    }
    static String mapearGatoEnAspiradora() {
        return "(3)";
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