import java.util.Scanner;

class ClasificacionDeEdad {
    public static void main(String[] args) {

    final int primeraInfanciaMaxima = 5;
    final int infanciaMaxima = 11;
    final int adolescenciaMaxima = 18;
    final int juventudMaxima = 25;
    final int adultezMaxima = 59;
    
        System.out.println("Ingrese una edad entre 0 y 100");
    Scanner scanner = new Scanner(System.in);
    int edad = scanner.nextInt();

    scanner.close();

    System.out.println (edad > 100 ? "Edad invalida" :
        (edad <= primeraInfanciaMaxima ? "Primera infancia" :
        (edad <= infanciaMaxima ? "Infancia" :
        (edad <= adolescenciaMaxima ? "Adolescencia" :
        (edad <= juventudMaxima ? "Juventud" :
        (edad <= adultezMaxima ? "Adultez" :
        "Adultez mayor")))))
    );
    }
 }
