import java.util.Scanner;

class ClasificacionConductor {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("¿Tiene licencia de conducir? (true/false): ");
        boolean tieneLicencia = scanner.nextBoolean();

        final int EDAD_NOVEL = 18;
        final int EDAD_EXPERIMENTADO = 20;
        final int EDAD_SENIOR = 28;
        final int EDAD_JUBILADO = 65;


        if (edad < EDAD_NOVEL){
            System.out.println("Menor de edad, no puede conducir");

        } else if (tieneLicencia){

            if(edad<EDAD_EXPERIMENTADO){
                System.out.println("Conductor novel. Puede conducir.");
            } else if (edad < EDAD_SENIOR){
                System.out.println("Conductor experimentado. Puede conducir.");
            } else if (edad < EDAD_JUBILADO){
                System.out.println("Conductor senior. Puede conducir.");
            } else {
                System.out.println("Conductor jubilado. Puede conducir.");
            }

        }else{
            System.out.println("Mayor sin licencia, no puede conducir");
        }

        scanner.close();
    }

}
