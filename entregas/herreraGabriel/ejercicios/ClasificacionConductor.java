import java.util.Scanner;

public class ClasificacionConductor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su edad:");
        int edad = sc.nextInt();

        System.out.println("¿Tiene licencia de conducir? (true/false):");
        boolean tieneLicencia = sc.nextBoolean();

        // Variables predefinidas
        String puedeConducirTxt = "Puede conducir.";
        String noPuedeConducirTxt = "No puede conducir.";

        String menorTxt = "Menor de edad";
        String mayorSinLicenciaTxt = "Mayor sin licencia";
        String novelTxt = "Conductor novel";
        String experimentadoTxt = "Conductor experimentado";
        String seniorTxt = "Conductor senior";
        String jubiladoTxt = "Conductor jubilado";

        // Clasificación con ternarios anidados
        String clasificacion = (edad < 18) ? menorTxt :
                               (!tieneLicencia) ? mayorSinLicenciaTxt :
                               (edad <= 19) ? novelTxt :
                               (edad <= 27) ? experimentadoTxt :
                               (edad <= 64) ? seniorTxt :
                               jubiladoTxt;

        // Puede conducir o no
        String permiso = (edad < 18 || !tieneLicencia) ? noPuedeConducirTxt : puedeConducirTxt;

        // Salida final
        System.out.println("Clasificación: " + clasificacion + ". " + permiso);

        sc.close();
    }
}
