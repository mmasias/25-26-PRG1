package Clasificadores;
import java.util.Scanner;

class ClasificacionConductor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese su edad:");
        int edad = scanner.nextInt();
        
        System.out.println("¿Tiene licencia de conducir? (Escriba 1 para SI, 0 para NO):");
        int respuesta = scanner.nextInt();
        
        boolean tieneLicencia = false;
        if (respuesta == 1) {
            tieneLicencia = true;
        }
        
        System.out.print("Clasificación: ");
        
        if (edad < 18) {
            System.out.println("Menor de edad, no puede conducir. No puede conducir.");
        } 
        if (edad >= 18 && tieneLicencia == false) {
            System.out.println("Sin licencia de conducir. No puede conducir.");
        }
        if (edad >= 18 && tieneLicencia == true) {
            
            int experiencia = edad - 18;
            
            if (experiencia < 2) {
                System.out.println("Conductor principiante. Puede conducir.");
            }
            if (experiencia >= 2 && edad < 65) {
                System.out.println("Conductor con experiencia. Puede conducir.");
            }
            if (edad >= 65) {
                System.out.println("Conductor jubilado. Puede conducir.");
            }
        }
        
        scanner.close();
    }
}