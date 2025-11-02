package entregas.sanmiguelHector.ejercicios;
import java.util.Scanner;

public class ClasificacionEdad {
    public static void main(String[] args) {

        final int PRIMERA_INFANCIA = 5;
        final int INFANCIA = 11;
        final int ADOLESCENCIA = 18;
        final int JUVENTUD = 25;
        final int ADULTEZ = 59;
        final int PERSONA_MAYOR = 100;
        final int EDAD_INVALIDA_MAYOR = 100;
        final int EDAD_INVALIDA_MENOR = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una edad entre 0 y 100");
        int edadUsuario = scanner.nextInt();

        if (edadUsuario > EDAD_INVALIDA_MAYOR || edadUsuario < EDAD_INVALIDA_MENOR) {
            System.out.println("Edad inválida");
        }
        if (edadUsuario <= PERSONA_MAYOR && edadUsuario > ADULTEZ) {
            System.out.println("Persona mayor");
        }
        if (edadUsuario < ADULTEZ && edadUsuario > JUVENTUD) {
            System.out.println("Adultez");
        }
        if (edadUsuario < JUVENTUD && edadUsuario > ADOLESCENCIA) {
            System.out.println("Juventud");
        }
        if (edadUsuario < ADOLESCENCIA && edadUsuario > INFANCIA) {
            System.out.println("Adolescente");
        }
        if (edadUsuario < INFANCIA && edadUsuario > PRIMERA_INFANCIA) {
            System.out.println("Infancia");
        }
        if (edadUsuario < PRIMERA_INFANCIA && edadUsuario >= EDAD_INVALIDA_MENOR) {
            System.out.println("Primera infancia");
        }
        scanner.close();    
    }
}
