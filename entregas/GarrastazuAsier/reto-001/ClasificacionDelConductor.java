
import java.util.Scanner;

class ClasificacionConductor {    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su edad:");
        int edad = sc.nextInt();

        System.out.println("¿Tiene licencia de conducir? (true/false):");
        boolean tieneLicencia = sc.nextBoolean();

        String clasificacion;
        boolean puedeConducir;

        if (edad < 18) {
            clasificacion = "Menor de edad, no puede conducir";
            puedeConducir = false;
        } else if (!tieneLicencia) {
            clasificacion = "Mayor sin licencia";
            puedeConducir = false;
        } else {
            // Tiene licencia y edad >= 18
            if (edad >= 18 && edad <= 19) {
                clasificacion = "Conductor novel";
            } else if (edad >= 20 && edad <= 27) {
                clasificacion = "Conductor experimentado";
            } else if (edad >= 28 && edad <= 64) {
                clasificacion = "Conductor senior";
            } else { // edad >= 65
                clasificacion = "Conductor jubilado";
            }
            puedeConducir = true;
        }

        System.out.print("Clasificación: " + clasificacion + ". ");
        if (puedeConducir) {
            System.out.println("Puede conducir.");
        } else {
            System.out.println("No puede conducir.");
        }

        sc.close();
    }
}