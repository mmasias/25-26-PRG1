package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;

class ClasificaciónDeEdades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la edad");
        int edad = scanner.nextInt();
        if (edad < 0 || edad > 100) {
            System.out.println("Edad Invalida");
            return;
        }
        if (edad <= 5) {
            System.out.println("Primera infancia");
            return;
        }
        if (edad <= 11) {
            System.out.println("Infancia");
            return;
        }
        if (edad <= 18) {
            System.out.println("Adolescencia");
            return;
        }
        if (edad <= 25) {
            System.out.println("Juventus");
            return;
        }
        if (edad <= 59) {
            System.out.println("Adultez");
            return;
        }
        if (edad <= 100) {
            System.out.println("Persona Mayor");
            return;
        }
        scanner.close();
    }

}