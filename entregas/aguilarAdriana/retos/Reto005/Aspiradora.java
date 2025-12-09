package entregas.aguilarAdriana.retos.Reto005;

import java.util.Arrays;
import java.util.Scanner;

public class Aspiradora {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

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
        int [] posicionGato = {3,3};
        String respuestaUsuario = " ";

        ensuciarEscenario(superficie);
        imprimirEscenario(superficie, posicionAspiradora, posicionGato);

        do {
            System.out.println("Presiona ENTER para el siguiente movimiento");
            respuestaUsuario = scanner.nextLine();
            
            moverAspiradora(posicionAspiradora, superficie);  
            limpiarEscenario(superficie, posicionAspiradora);
            moverGato(posicionGato, posicionAspiradora, superficie);
            gatoEnsucia(posicionGato, superficie);
            imprimirEscenario(superficie, posicionAspiradora, posicionGato);
        } while (estaSucio(superficie));
        
        scanner.close();


    }

    static String posicionGatoAspiradora (int[] posicionGato, int[] posicionAspiradora, int [][] superficie) {
        if (posicionGato[0] == posicionAspiradora[0] && posicionGato[1] == posicionAspiradora[1] ) {
            return ("MIAUUUUUW");
        }
        return "";  
    }

     static boolean posicionValidaGato(int[] posicionGato, int[][] superficie) {
        if (posicionGato[0] < 0 || posicionGato[0] >= superficie.length) {
            return (false);
        }
        if (posicionGato[1] < 0 || posicionGato[1] >= superficie[0].length) {
            return (false);
        }

        return (true);

    }

    static String mapearGato() {
        return "jeje";
    }

    static void moverGato (int [] posicionGato, int[] posicionAspiradora, int[][] superficie) {
         final int X = 1;
        final int Y = 0;

        int movimientoX = (int) (Math.random() * 3) - 1;
        int movimientoY = (int) (Math.random() * 3) - 1;

        posicionGato[X] = posicionGato[X] + movimientoX;
        posicionGato[Y] = posicionGato[Y] + movimientoY;

        if (!posicionValidaGato(posicionGato, superficie)) {
            posicionGato[X] = posicionGato[X] - movimientoX;
            posicionGato[Y] = posicionGato[Y] - movimientoY;
        }
    }

    static void gatoEnsucia (int [] posicionGato, int [][] superficie) {
          for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                if (posicionGato[0] == i && posicionGato[1] == j) {
                    if (superficie[i][j] < 4) {  
                        superficie[i][j] = superficie[i][j] + 1;
                    }
                }
            }
        }

    }

    static boolean estaSucio(int[][] superficie) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                if (superficie[i][j] > 0) {
                    return (true);
                }
            }
        }
        return (false);
    }

    static boolean posicionValida(int[] posicionAspiradora, int[][] superficie) {
        if (posicionAspiradora[0] < 0 || posicionAspiradora[0] >= superficie.length) {
            return (false);
        }
        if (posicionAspiradora[1] < 0 || posicionAspiradora[1] >= superficie[0].length) {
            return (false);
        }

        return (true);

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

    static void limpiarEscenario(int[][] superficie, int[] posicionAspiradora) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[i].length; j++) {
                if (posicionAspiradora[0] == i && posicionAspiradora[1] == j) {
                    if (superficie[i][j] > 0) {  
                        superficie[i][j] = superficie[i][j] - 1;
                    }
                }
            }
        }
    }

    static void imprimirEscenario(int[][] superficie, int[] posicionAspiradora, int [] posicionGato) {

        imprimirBordeHorizontal(superficie[0].length);
        for (int fila = 0; fila < superficie.length; fila++) {
            imprimirBordeVertical();

            for (int columna = 0; columna < superficie[fila].length; columna++) {

                if (fila == posicionAspiradora[0] && columna == posicionAspiradora[1]) {
                    System.out.print(mapearAspiradora());
                } else if (fila == posicionGato[0] && columna == posicionGato[1]) {
                    System.out.print(mapearGato());
                }else {
                    int mapita = superficie[fila][columna];
                    System.out.print(mapear(mapita));
                }

            }
            imprimirBordeVertical();
            System.out.println();
        }
        imprimirBordeHorizontal(superficie[0].length);
        
        System.out.println(posicionGatoAspiradora(posicionGato, posicionAspiradora, superficie));
    }

    static String mapearAspiradora() {
        return "(_)";
    }

    static void imprimirBordeHorizontal(int length) {
        System.out.println("===".repeat(length));
    }

    static void imprimirBordeVertical() {
        System.out.print("|");
    }

    static String mapear(int mapita) {

        String[] estadosSuciedad = {
                " . ",
                "...",
                "ooo",
                "OOO",
                "***"
        };
        return estadosSuciedad[mapita];
    }

    static void ensuciarEscenario(int[][] superficie) {

        for (int fila = 0; fila < superficie.length; fila++) {
            for (int columna = 0; columna < superficie[fila].length; columna++) {

                superficie[fila][columna] = (int) (Math.random() * 5);
            }

        }
    }

}


