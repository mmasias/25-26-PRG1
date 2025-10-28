import java.util.Scanner;

class ClasificacionEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese una edad entre 0 y 100");
        int edad = scanner.nextInt();
        
        System.out.print("> ");
        
        if (edad < 0 || edad > 100) {
            System.out.println("Edad inválida");
        } else if (edad >= 0 && edad <= 5) {
            System.out.println("Primera infancia");
        } else if (edad >= 6 && edad <= 11) {
            System.out.println("Infancia");
        } else if (edad >= 12 && edad <= 18) {
            System.out.println("Adolescencia");
        } else if (edad >= 19 && edad <= 26) {
            System.out.println("Juventud");
        } else if (edad >= 27 && edad <= 59) {
            System.out.println("Adultez");
        } else if (edad >= 60 && edad <= 100) {
            System.out.println("Tercera edad");
        }
        
        scanner.close();
    }
}