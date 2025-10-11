import java.util.Scanner;

class DevolverCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int BILLETE_DE_CIEN = 100;
        final int BILLETE_DE_CINCUENTA = 50;
        final int BILLETE_DE_VEINTE = 20;   
        final int BILLETE_DE_DIEZ = 10;
        final int BILLETE_DE_CINCO = 5;
        final int MONEDA_DE_DOS = 2;
        final int MONEDA_DE_UNO = 1;
        
        System.out.println("¿Cuantos euros debe pagar?");
        int totalApagar = scanner.nextInt();

        System.out.println("¿Con cuantos euros paga? ");
        int dineroIntroducido = scanner.nextInt();
        
        int cambio = dineroIntroducido - totalApagar;

        int residuoCambioDeCien = cambio / BILLETE_DE_CIEN;
        cambio %= BILLETE_DE_CIEN;

        int residuoCambioDeCincuenta = cambio / BILLETE_DE_CINCUENTA;
        cambio %= BILLETE_DE_CINCUENTA;

        int residuoCambioDeVeinte = cambio / BILLETE_DE_VEINTE;
        cambio %= BILLETE_DE_VEINTE;

        int residuoCambioDeDiez = cambio / BILLETE_DE_DIEZ;
        cambio %= BILLETE_DE_DIEZ;

        int residuoCambioDeCinco = cambio / BILLETE_DE_CINCO;
        cambio %= BILLETE_DE_CINCO;

        int residuoCambioDeDos = cambio / MONEDA_DE_DOS;
        cambio %= MONEDA_DE_DOS;

        int residuoCambioDeUno = cambio / MONEDA_DE_UNO;
        cambio %= MONEDA_DE_UNO;

        System.out.println( residuoCambioDeCien + " billete(s) de " + BILLETE_DE_CIEN + "€");
        System.out.println( residuoCambioDeCincuenta + " billete(s) de " + BILLETE_DE_CINCUENTA + "€");
        System.out.println( residuoCambioDeVeinte + " billete(s) de " + BILLETE_DE_VEINTE + "€");
        System.out.println( residuoCambioDeDiez + " billete(s) de " + BILLETE_DE_DIEZ + "€");
        System.out.println( residuoCambioDeCinco + " billete(s) de " + BILLETE_DE_CINCO + "€");
        System.out.println( residuoCambioDeDos + " moneda(s) de " + MONEDA_DE_DOS + "€");
        System.out.println( residuoCambioDeUno + " moneda(s) de  " + MONEDA_DE_UNO + "€");
        scanner.close();
    }
}