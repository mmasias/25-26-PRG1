package entregas.sanmiguelHector.ejercicios;
import java.util.Scanner;

public class ClasificacionConductor {
    public static void main(String[] args) {
        
        final int MENOR_DE_EDAD = 18;
        final String DENEGADO = "No puede conducir.";
        final String ACEPTADO = "Puede conducir";
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad");
        int edadUsuario = scanner.nextInt();

        if (edadUsuario < MENOR_DE_EDAD) {
            System.out.println("Menor de edad. " + DENEGADO);
        }
        if (edadUsuario >= MENOR_DE_EDAD){

            System.out.println("¿Tiene licencia de conducir? (true/false)");
            boolean licencia = scanner.nextBoolean();

            if (licencia == false) {
                System.out.println(DENEGADO);
            }
            if (licencia == true) {

                final int CONDUCTOR_NOVEL = 19;
                final int CONDUCTOR_EXPERIMENTADO = 27;
                final int CONDUCTOR_SENIOR = 64;
                final int CONDUCTOR_JUBILADO = 65;

                if (edadUsuario >= CONDUCTOR_JUBILADO) {
                    System.out.println("Conductor jubilado. " + ACEPTADO);
                }
                if (edadUsuario <= CONDUCTOR_SENIOR && edadUsuario > CONDUCTOR_EXPERIMENTADO) {
                    System.out.println("Conductor senior. " + ACEPTADO);
                }
                if (edadUsuario <= CONDUCTOR_EXPERIMENTADO && edadUsuario > CONDUCTOR_NOVEL) {
                    System.out.println("Conductor experimentado. " + ACEPTADO);
                }
                if (edadUsuario <= CONDUCTOR_NOVEL) {
                    System.out.println("Conductor novel. " + ACEPTADO);
                }
            }
        }
        scanner.close();
    }
}