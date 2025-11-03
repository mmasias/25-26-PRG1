import java.util.Scanner;

class UnPozo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final String APERTURA_POZO = "[__]              [__]";
        final String PARED_POZO = "  []:. :. :. :. :.[]";
        final String SUELO_POZO = "  [][][][][][][][][]";
        final String AGUA = "  []~~~~~~~~~~~~~~[]";
        final String CARACOL_VIVO = "  []    _@)_/´    []";
        int profundidad_pozo = 20;
        System.out.println("¿Cúantos metros de agua tiene el pozo?");
        int cantidad_agua = scanner.nextInt();
        System.out.println("¿A qué profundidad está el caracol?");
        int profundidad_caracol = scanner.nextInt();
        int cantidad_pared = profundidad_pozo - cantidad_agua;

        System.out.println(APERTURA_POZO);
        for(int i = 0; i<=profundidad_pozo ;i++ ){
            if(cantidad_pared >= i && i != profundidad_caracol){
                System.out.print(PARED_POZO);
            }else if(i == profundidad_caracol){
                System.out.print(CARACOL_VIVO);
            }else{
                System.out.print(AGUA);
            }
            System.out.println(" _ __" + i);
        }
        System.out.println(SUELO_POZO);

    }
}
