import java.util.Scanner;

class ClasificacionDeEdad {
    public static void main(String[] args) {

    final int PRIMERA_INFANCIA_MAXIMA = 5;
    final int INFANCIA_MAXIMA = 11;
    final int ADOLESCENCIA_MAXIMA = 18;
    final int JUVENTUD_MAXIMA = 25;
    final int ADULTEZ_MAXIMA = 59;
    
        System.out.println("Ingrese una edad entre 0 y 100");
    Scanner scanner = new Scanner(System.in);
    int edad = scanner.nextInt();

    scanner.close();

    String resultado;

    if (edad > 100) { resultado = "Edad invalida"; }
    else if(edad <= PRIMERA_INFANCIA_MAXIMA) {
            resultado = "Primera Infancia";
        } else if (edad <= INFANCIA_MAXIMA) {
            resultado = "Infancia";
        } else if (edad <= ADOLESCENCIA_MAXIMA) {
            resultado = "Adolescencia";
        } else if (edad <= JUVENTUD_MAXIMA) {
            resultado = "Juventud";
        } else if (edad <= ADULTEZ_MAXIMA) {
            resultado = "Adultez";
        } else {
            resultado = "Adulto Mayor";
        }
    

    System.out.println ("Usted es de" + resultado);
    }
 }
