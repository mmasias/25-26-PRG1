import java.util.Scanner;

public class ClasificacionEdad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int PRIERA_INFANCIA = 5;
        final int INFANCIA = 11;
        final int ADOLESCENCIA = 18;
        final int JUVENTUD = 25;
        final int ADULTEZ = 59;
        final int PERSONA_MAYOR = 100;
        final int EDAD_INVALIDA_1 = 0;
        final int EDAD_INVALIDA_2 = 100;

        System.out.println("Introduzca una edad entre 0 y 100");
        int edadUsuario = scanner.nextInt();

        if (edadUsuario < EDAD_INVALIDA_1 || edadUsuario > EDAD_INVALIDA_2) {
            System.out.println("LA EDAD INGRESADA NO ES VALIDA");
        }

        if (edadUsuario > ADULTEZ && edadUsuario <= PERSONA_MAYOR) {
            System.out.println("Persona mayor");
        }
        if (edadUsuario > JUVENTUD && edadUsuario < ADULTEZ) {
            System.out.println("Persona adulta");
        }
        if (edadUsuario > ADOLESCENCIA && edadUsuario < JUVENTUD) {
            System.out.println("Persona juventud");
        }
        if (edadUsuario > INFANCIA && edadUsuario < ADOLESCENCIA) {
            System.out.println("Persona adolescente");
        }

        if (edadUsuario < PRIERA_INFANCIA && edadUsuario >= EDAD_INVALIDA_1) {
            System.out.println("Primera infancia");
        }

        scanner.close();
    }

}
