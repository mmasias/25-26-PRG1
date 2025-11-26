import java.util.Scanner;

public class Pozocaracolmuerto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int PROFUNDIDAD_POZO = 20;
        final String BORDESPOZO = "[__]              [__]";
        final String SUELOPOZO = "  [][][][][][][][][] ";
        final String PAREDPOZO = "  []:. :. :. :. :.[]";
        final String SEPARADOR = " _ __ ";
        final String AGUA = "  []~~~~~~~~~~~~~~[]";

        System.out.println("¿Cuántos metros de agua contiene el pozo?");
        final int PROFUNDIDAD_AGUA = scanner.nextInt();
        System.out.println("¿A qué profundidad está el caracol?");
        final int PROFUNDIDAD_CARACOL = scanner.nextInt();
        boolean caracolMuerto = PROFUNDIDAD_CARACOL > (PROFUNDIDAD_POZO - PROFUNDIDAD_AGUA);
        final String caracol = caracolMuerto ? "  []~~~~_@)_-,~~~~[]" : "  []    _@)_/’    []";
        System.out.println();
        System.out.println(BORDESPOZO);
        for (int profundidad = 0; profundidad <= PROFUNDIDAD_POZO; profundidad = profundidad + 1) {

            if (profundidad == PROFUNDIDAD_CARACOL) {
                System.out.print(caracol);
            } else if (profundidad > PROFUNDIDAD_POZO - PROFUNDIDAD_AGUA) {
                System.out.print(AGUA);
            } else {
                System.out.print(PAREDPOZO);
            }

            System.out.println(SEPARADOR + profundidad);

        }
        System.out.println(SUELOPOZO);
        if (caracolMuerto) {
            System.out.println("el caracol esta muerto :(");
        }
        System.out.println("");

        scanner.close();
    }
}
