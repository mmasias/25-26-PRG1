package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;

class ClasificaciónDeConductores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su edad : ");
        int edadDelConductor = scanner.nextInt();
        System.out.println("¿Tiene licencia de conducir? (true/false):");
        boolean licencia = scanner.nextBoolean();
        String clasificación = "";
        String puedeConducir = "";

        if (edadDelConductor < 18) {
            clasificación = "Menor de edad";
            puedeConducir = "No puede conducir";

        }
        if (edadDelConductor >= 18 && !licencia) {
            clasificación = "Mayor sin licencia";
            puedeConducir = "No puede conducir";

        }
        if (edadDelConductor >= 18 && edadDelConductor <= 19 && licencia) {
            clasificación = "Conductor novel";
            puedeConducir = "Puede Conducir";

        }
        if (edadDelConductor >= 20 && edadDelConductor <= 27 && licencia) {
            clasificación = "Conductor experimentado";
            puedeConducir = "Puede conducir";

        }
        if (edadDelConductor >= 28 && edadDelConductor <= 64 && licencia) {
            clasificación = "Conductor senior";
            puedeConducir = "Puede Conducir";

        }
        if (edadDelConductor >= 65 && licencia) {
            clasificación = "Conductor jubilado";
            puedeConducir = "Puede Conducir";

        }
        System.out.println("Clasificación : " + clasificación + "." + puedeConducir + ":");
        scanner.close();

    }

}
