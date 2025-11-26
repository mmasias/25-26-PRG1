public class Pozoagua3m {
    public static void main(String[] args) {
        final int PROFUNDIDAD_POZO = 20;
        final String BORDESPOZO = "[__]              [__]";
        final String SUELOPOZO = "  [][][][][][][][][] ";
        final String PAREDPOZO = "  []:. :. :. :. :.[]";
        final String SEPARADOR = " _ __ ";
        final String AGUA = "  []~~~~~~~~~~~~~~[]";
        final int PROFUNDIDAD_AGUA = 3;

        System.out.println(BORDESPOZO);
        for (int profundidad = 0; profundidad <= PROFUNDIDAD_POZO; profundidad = profundidad + 1) {

            if (profundidad > PROFUNDIDAD_POZO - PROFUNDIDAD_AGUA) {
                System.out.print(AGUA);
            } else {
                System.out.print(PAREDPOZO);
            }

            System.out.println(SEPARADOR + profundidad);

        }
        System.out.println(SUELOPOZO);
    }
}
