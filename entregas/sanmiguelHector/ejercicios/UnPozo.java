package entregas.sanmiguelHector.ejercicios;

import java.util.Scanner;

public class UnPozo {
    public static void main(String[] args) {

        final String PARTE_ARRIBA_POZO = "[__]              [__]";
        final String LATERAL_POZO = "[]";
        final String AIRE = ":.";
        final String AGUA = "~~";
        final String BASE_POZO = "  [][][][][][][][][] ";
        final int ANCHURA_POZO = 7;
        final String CARACOL = "_@)_/'";
        int fila;
        int columna;

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos metros de agua tiene el pozo?");
        int metrosDeAgua = scanner.nextInt();
        System.out.println("¿Cuántos metros mide el pozo?");
        int profundidadDelPozo = scanner.nextInt();
        System.out.println("¿A qué altura está el caracol?");
        int alturaDelCaracol = scanner.nextInt();


        System.out.println(PARTE_ARRIBA_POZO);
        for (fila = 1; fila <= profundidadDelPozo; fila++) {
            if (fila == alturaDelCaracol) {
                for (columna = 1; columna <= ANCHURA_POZO - 1; columna++) {
                    if (columna == 1) {
                        System.out.print("  " + LATERAL_POZO);
                    }
                    if (columna == 3) {
                        System.out.print(CARACOL);
                    }
                    if (columna == ANCHURA_POZO - 1) {
                        System.out.print(LATERAL_POZO);
                    } else if (columna != 3) {
                        System.out.print(AIRE);
                    }
                }
            } else if (fila <= profundidadDelPozo - metrosDeAgua) {
                for (columna = 1; columna <= ANCHURA_POZO; columna++) {
                    if (columna == 1) {
                        System.out.print("  " + LATERAL_POZO);
                    }
                    System.out.print(AIRE);
                    if (columna == ANCHURA_POZO) {
                        System.out.print(LATERAL_POZO);
                    }
                }
            } else {
                for (columna = 1; columna <= ANCHURA_POZO; columna++) {
                    if (columna == 1) {
                        System.out.print("  " + LATERAL_POZO);
                    }
                    System.out.print(AGUA);
                    if (columna == ANCHURA_POZO) {
                        System.out.print(LATERAL_POZO);
                    }
                }
            }
            System.out.print(" _ __ " + fila);
            System.out.println();
        }
        System.out.println(BASE_POZO);
    scanner.close();
    }
}