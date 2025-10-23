package entregas.moraDaniel.Ejercicios;

import java.util.Scanner;

class ClasificaciónDeEdades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la edad");
        int edad = scanner.nextInt();
        String categoria = "";
        if (edad < 0 || edad > 100) {
            categoria = "Edad Invalida";
        }
        if (edad >= 0 && edad <= 5) {
            categoria = "Primera infancia";
        }
        if (edad >= 6 && edad <= 11) {
            categoria = "Infacia";
        }
        if (edad >= 12 && edad <= 18) {
            categoria = "Adolescencia";
        }
        if (edad >= 19 && edad <= 25) {
            categoria = "Juventud";
        }
        if (edad >= 26 && edad <= 59) {
            categoria = "Adultez";
        }
        if (edad >= 60 && edad <= 100) {
            categoria = "Persona Mayor";
        }
        System.out.println(categoria);
        scanner.close();
    }

}
