import java.util.Scanner;

class DibujoDeUnPozo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la profundidad del pozo: ");
        int profundidad = scanner.nextInt();
        
        System.out.print("Ingrese la cantidad de metros de agua: ");
        int cantidadAgua = scanner.nextInt();

        System.out.print("Ingrese la profundidad del caracol: ");
        int caracolValor = scanner.nextInt();


        System.out.println("    []____________________[]   ");
        
        for (int i = 0; i < profundidad; i = i + 1) {
            
            boolean hayAgua = (cantidadAgua > 0 && i >= profundidad - cantidadAgua);
            boolean caracolEstaAqui = (i == caracolValor - 1);
            
            int numeroLinea = i + 1; 
            
            if (caracolEstaAqui) {
                if (hayAgua) {
                    System.out.println(numeroLinea + "  |~~~~~~~~_@__~~~~~~~~|   "); 
                } else {
                    System.out.println(numeroLinea + "  |:.:.:.:_@)_/.:.:.:.:|   "); 
                }
            } else {
                if (hayAgua) {
                    System.out.println(numeroLinea + "  |~~~~~~~~~~~~~~~~~~~~|   ");
                } else {
                    System.out.println(numeroLinea + "  |:.:.:.::.:.:.:.:.:.:|   "); 
                }
            }
        }
        System.out.println("   |[][][][][][][][][][]|   ");
        boolean caracolMuerto = (caracolValor > profundidad - cantidadAgua);
        if (caracolMuerto) {
            System.out.println(" Ahogaste al caracol :C ");
        } 
        
        
    }
}
