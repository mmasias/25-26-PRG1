import java.util.Scanner;

public class ClasificacionEdad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una edad entre 0 y 100");
        int edad = sc.nextInt();

        // Variables predefinidas
        String primeraInfancia = "Primera infancia";
        String infancia = "Infancia";
        String adolescencia = "Adolescencia";
        String juventud = "Juventud";
        String adultez = "Adultez";
        String personaMayor = "Persona mayor";
        String edadInvalida = "Edad inválida";

        // Clasificación usando solo operadores ternarios
        String clasificacion = (edad < 0 || edad > 100) ? edadInvalida
                : (edad <= 5) ? primeraInfancia
                        : (edad <= 11) ? infancia
                                : (edad <= 18) ? adolescencia
                                        : (edad <= 25) ? juventud : (edad <= 59) ? adultez : personaMayor;

        // Salida
        System.out.println("> " + clasificacion);

        sc.close();
    }
}
