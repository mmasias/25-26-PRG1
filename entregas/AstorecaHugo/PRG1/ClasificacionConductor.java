import java.util.Scanner;


class ClasificacionConductor {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        System.out.println("Ingrese su edad:");
        int edad = teclado.nextInt();
        System.out.println("¿Tiene licencia de conducir ?  (true/false) ");
        boolean tieneLicencia = teclado.nextBoolean();

        if ( edad < 18 && tieneLicencia == false || tieneLicencia == true){
            System.out.println("No pude tener licencia de conducir");
        } else if ( edad >= 18 && tieneLicencia ==false ){
            System.out.println("mayor sin licencia de conducir");
        
        } else if ( edad >= 18 || edad<= 19 && tieneLicencia == true){
            System.out.println( "Conductor novel");

        } else if ( edad >= 20 || edad <= 27 && tieneLicencia == true){
            System.out.println("Conductor experimentado");
        } else if ( edad >= 28 || edad <= 64 && tieneLicencia == true){
            System.out.println( "Conductor senior");

        } else if ( edad >= 65 && tieneLicencia == true ){
            System.out.println( "Conductor jubilado");
        }
    teclado.close();
       }
        } 
   
