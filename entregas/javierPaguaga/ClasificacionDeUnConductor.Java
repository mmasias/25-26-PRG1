import java.util.Scanner;

class ClasificacionDeUnConductor {
    public static void main(String[] args) {

    final int EDAD_CONDUCTOR_MENOR = 17;
    final int EDAD_CONDUCTOR_MAYOR = 18;
    final int EDAD_CONDUCTOR_EXPERIMENTADO = 20;
    final int EDAD_CONDUCTOR_SENIOR = 28;
    final int EDAD_CONDUCTOR_JUBILADO = 65;
    
        System.out.println("Ingrese su edad");
    Scanner scanner = new Scanner(System.in);
    int edad = scanner.nextInt();

    System.out.println("Tiene licencia de conducir? (true/false)");
    Boolean licenciaDeConducir = scanner.nextBoolean();

scanner.close();
    
    boolean error = false;
    String clasificacion = "";

        if (edad <= EDAD_CONDUCTOR_MENOR) {
            clasificacion = "Menor de edad, no puede conducir.";
        } else if (!licenciaDeConducir) {
            clasificacion = "Mayor sin licencia.";
        } else if (edad >= EDAD_CONDUCTOR_JUBILADO) {
            clasificacion = "Conductor jubilado.";
        } else if (edad >= EDAD_CONDUCTOR_SENIOR) {
            clasificacion = "Conductor senior.";
        } else if (edad >= EDAD_CONDUCTOR_EXPERIMENTADO) {
            clasificacion = "Conductor experimentado.";
        } else if (edad >= EDAD_CONDUCTOR_MAYOR) {
            clasificacion = "Conductor novel.";
        } else {
            error = true;
        }

        if (!error) {
            System.out.println("Clasificación: " + clasificacion);
            System.out.print (licenciaDeConducir  ? "Puede conducir" : "no puede conducir");
    } else {
        System.out.println("Error en la clasificación.");
    }
 }
}