import java.util.Scanner;

public class ClasificacionConductor {
    public static void main(String[] args) {
        final int CONDUCTOR_JUBILADO = 65;
        final int CONDUCTOR_SENIOR = 64;
        final int CONDUCTOR_EXPERIMENTADO = 27;
        final int CONDUCTOR_NOVEL = 19;
        final int MENOR_EDAD = 18;
        final String ACEPTADO = "Puedes conducir.";
        final String DENEGADO = "No " + ACEPTADO;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su edad: ");
        int edadDelusuario = scanner.nextInt();
        System.out.println("¿Tiene licencia de conducir? (true/false):");
        boolean licenciaConducir = scanner.nextBoolean();

        if (edadDelusuario < MENOR_EDAD) {
            System.out.println("Eres menor de edad, " + DENEGADO);
        }

        if (edadDelusuario >= MENOR_EDAD) {
            if (licenciaConducir == false) {
                System.out.println("No tienes licencia," + DENEGADO);
            }
            if (licenciaConducir == true) {
                if (edadDelusuario >= CONDUCTOR_JUBILADO) {
                    System.out.println("Conductor jubilado," + ACEPTADO);
                }
                if (edadDelusuario >= CONDUCTOR_EXPERIMENTADO && edadDelusuario <= CONDUCTOR_SENIOR) {
                    System.out.println("Conductor senior" + ACEPTADO);
                }
                if (edadDelusuario > CONDUCTOR_NOVEL && edadDelusuario <= CONDUCTOR_EXPERIMENTADO) {
                    System.out.println("Conductor experimentado, " + ACEPTADO);
                }
                if (edadDelusuario <= CONDUCTOR_NOVEL) {
                    System.out.println("Conductor novel, " + ACEPTADO);
                }

            }
        }
        scanner.close();
    }
}
