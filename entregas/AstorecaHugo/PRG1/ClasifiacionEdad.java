
import java.util.Scanner;

class ClasifiacionEdad {

    public static void main(String[] args) {
        

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introducce tu edad:");
        int edad = teclado.nextInt();
        if (edad < 0) {
            System.out.println("No has nacio aun");
        } else if (edad > 100) {
            System.out.println("EDad no valida");
        } else {
            if (edad >0 || edad <= 5){
                System.out.println("Estas en la primera infancia");
            }else if (edad >= 6 || edad <= 11){
                System.out.println( "Estas en la infancia");
            } else if ( edad >= 12 || edad <= 18){
                System.out.println(" Estas en la adolescencia");
            } else if ( edad >= 19 || edad <= 25){
                System.out.println ("Estas en la juventud");
            }else if ( edad >= 26 || edad <= 59){
                System.out.println("Estas en la adultez");
            } else if ( edad >= 60 || edad <= 100){
             System.out.println("Eres una perosna mayor");

        }
        }teclado.close();
        
        
    }

}


        
    
    



