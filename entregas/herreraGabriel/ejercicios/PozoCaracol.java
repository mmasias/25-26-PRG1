import java.util.Scanner;

public class PozoCaracol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        while (opcion != 5) {
            System.out.println("\n=== SIMULADOR DEL POZO Y EL CARACOL ===");
            System.out.println("1. Pozo simple");
            System.out.println("2. Pozo con agua");
            System.out.println("3. Pozo con agua y caracol");
            System.out.println("4. Pozo con validacion (caracol puede morir)");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            
            if (opcion == 1) {
                dibujarPozoSimple();
            } else if (opcion == 2) {
                System.out.print("\nCuantos metros de agua contiene el pozo? ");
                int agua = scanner.nextInt();
                dibujarPozoConAgua(agua);
            } else if (opcion == 3) {
                System.out.print("\nCuantos metros de agua contiene el pozo? ");
                int agua = scanner.nextInt();
                System.out.print("A que profundidad esta el caracol? ");
                int caracol = scanner.nextInt();
                dibujarPozoConCaracol(agua, caracol, false);
            } else if (opcion == 4) {
                System.out.print("\nCuantos metros de agua contiene el pozo? ");
                int agua = scanner.nextInt();
                System.out.print("A que profundidad esta el caracol? ");
                int caracol = scanner.nextInt();
                dibujarPozoConCaracol(agua, caracol, true);
            } else if (opcion == 5) {
                System.out.println("\nGracias por usar el simulador!");
            } else {
                System.out.println("\nOpcion no valida");
            }
        }
        
        scanner.close();
    }
    
    public static void dibujarPozoSimple() {
        System.out.println("\n[__]              [__]");
        
        for (int i = 0; i <= 20; i++) {
            System.out.println("  []:. :. :. :. :.[] _ __ " + i);
        }
        
        System.out.println("  [][][][][][][][][]");
    }
    
    public static void dibujarPozoConAgua(int metrosAgua) {
        System.out.println("\n[__]              [__]");
        
        for (int i = 0; i <= 20; i++) {
            if (i > 20 - metrosAgua) {
                System.out.println("  []~~~~~~~~~~~~~~[] _ __ " + i);
            } else {
                System.out.println("  []:. :. :. :. :.[] _ __ " + i);
            }
        }
        
        System.out.println("  [][][][][][][][][]");
    }
    
    public static void dibujarPozoConCaracol(int metrosAgua, int profundidadCaracol, boolean validar) {
        System.out.println("\n[__]              [__]");
        
        boolean caracolMuerto = profundidadCaracol > 20 - metrosAgua;
        
        for (int i = 0; i <= 20; i++) {
            if (i == profundidadCaracol) {
                if (validar && caracolMuerto) {
                    System.out.println("  []~~~~_@)_-,~~~~[] _ __ " + i);
                } else {
                    System.out.println("  []    _@)_/'    [] _ __ " + i);
                }
            } else if (i > 20 - metrosAgua) {
                System.out.println("  []~~~~~~~~~~~~~~[] _ __ " + i);
            } else {
                System.out.println("  []:. :. :. :. :.[] _ __ " + i);
            }
        }
        
        System.out.println("  [][][][][][][][][]");
        
        if (validar && caracolMuerto) {
            System.out.println("\nEl caracol esta muerto :(");
        } else if (validar) {
            System.out.println("\nEl caracol esta vivo :)");
        }
    }
}