package Clasificadores;
import java.util.Scanner;

class ClasificacionEdad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("System.out.println(\"Ingrese su edad (de 0 a 100):");

        int edad = scanner.nextInt();

        if (edad < 18) {
            System.out.println("Tienes " + edad + ", eres menor de Edad");
        }
        Boolean mayorDeEdad = true;
        if (edad >= 18 && edad < 65) {
            System.out.println("Tienes " + edad + ", eres mayor de edad");
        }
        if (edad >= 65) {
            System.out.println("Tienes " + edad + ", eres de tercera edad");
        }

    }

}