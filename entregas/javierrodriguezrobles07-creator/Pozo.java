public class Pozo {
    public static void main(String[] args) {

        final int PROFUNDIDAD_POZO = 20;
        final String BORDE_SUPERIOR = "[__]              [__]";
        final String PARED = ""; 
        final String BORDE_INFERIOR = "";
        final String SEPARADOR = ""; 
        final int PROFUNDIDAD_AGUA = 3;
        final String AGUA = "" ; 
        final int PROFUNDIDAD_CARACOL = 8;
        final String CARACOL = "" ; 

        System.out.println(BORDE_SUPERIOR);
        for(int profundidad = 0; profundidad <= PROFUNDIDAD_POZO; profundidad = profundidad + 1) {

            if (profundidad >= PROFUNDIDAD_POZO - PROFUNDIDAD_AGUA) {
                System.out.println(AGUA);
            } else {
                System.out.println(PARED);  
            }
            System.out.println(SEPARADOR + profundidad);

        }
    } 
}
