public class UnPozo {
    public static void main(String[] args) {

        final String PARTE_ARRIBA_POZO = "[__]              [__]";
        final String LATERAL_POZO = "[]";
        final String AGUA = ":. ";
        final int PROFUNDIDAD_POZO = 10;
        final int ANCHURA_POZO = 5;

        System.out.print(PARTE_ARRIBA_POZO);
        for (int columna = 1; columna <= PROFUNDIDAD_POZO; columna++) {
            for (int fila = 1; fila <= ANCHURA_POZO; fila++){
                if (fila == 1 || fila == ANCHURA_POZO) {
                    System.out.print(LATERAL_POZO);
                }
                System.out.print(AGUA);
            }
            System.out.println();
        }
    }
}