import java.util.Scanner;

class ClasificacionDeUnConductor {
    public static void main(String[] args) {

    final int conductorMenorDeEdadMaximo = 17;
    final int conductorMayorDeEdad = 18;
    final int conductorExperimentado = 20;
    final int conductorSenior = 28;
    final int conductorJubilado = 65;
    
        System.out.println("Ingrese su edad");
    Scanner scanner = new Scanner(System.in);
    int edad = scanner.nextInt();

    System.out.println("Tiene licencia de conducir? (true/false)");
    Boolean licenciaDeConducir = scanner.nextBoolean();

scanner.close();
    
    String clasificacion;

        if (edad <= conductorMenorDeEdadMaximo) {
            clasificacion = "Menor de edad, no puede conducir.";
        } else if (!licenciaDeConducir) {
            clasificacion = "Mayor sin licencia.";
        } else if (edad >= conductorJubilado) {
            clasificacion = "Conductor jubilado.";
        } else if (edad >= conductorSenior) {
            clasificacion = "Conductor senior.";
        } else if (edad >= conductorExperimentado) {
            clasificacion = "Conductor experimentado.";
        } else {
            clasificacion = "Conductor novel.";
        }

        System.out.println("Clasificación: " + clasificacion);

    System.out.print (licenciaDeConducir  ? "Puede conducir" : "no puede conducir");

    }
 }