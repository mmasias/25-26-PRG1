package entregas.sanmiguelHector.ejercicios;

public class UnPozo {
    public static void main(String[] args) {

        final String PARTE_ARRIBA_POZO = "[__]              [__]";
        final String LATERAL_POZO = "[]";
        final String AIRE = ":.";
        final String AGUA = "~~";
        final String BASE_POZO = "  [][][][][][][][][] ";
        final int PROFUNDIDAD_POZO = 10;
        final int ANCHURA_POZO = 7;
        int fila;
        int columna;

        System.out.println(PARTE_ARRIBA_POZO);
        for (fila = 1; fila <= PROFUNDIDAD_POZO; fila++) {
            if (fila <= PROFUNDIDAD_POZO - 3) {
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
    }
}