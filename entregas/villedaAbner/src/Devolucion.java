import java.util.Scanner;

class Devolucion {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int pago;
        int deposito;
        int billete100;
        int billete50;
        int billete20;
        int billete10;
        int billete5;
        int moneda2;
        int moneda1;

        System.out.print("¿Cuántos euros debe de pagar?: ");
        pago = scr.nextInt();
        System.out.print("¿Con cuántos euros paga?: ");
        deposito = scr.nextInt();
        int cambio = pago - deposito;
        cambio *= (cambio < 0) ? -1 : 1;
        int cambioOriginal = cambio;

        billete100 = cambio / 100;
        cambio = cambio % 100;
        billete50 = cambio % 100 / 50;
        cambio = cambio % 50;
        billete20 = cambio / 20;
        cambio = cambio % 20;
        billete10 = cambio / 10;
        cambio = cambio % 10;
        billete5 = cambio / 5;
        cambio = cambio % 5;
        moneda2 = cambio / 2; 
        moneda1 = cambio %2;

        System.out.println("Su cambio total es de " + cambioOriginal);
        System.out.println(billete100 + " billete(s) de 100 €");
        System.out.println(billete50 + " billete(s) de 50 €");
        System.out.println(billete20 + " billete(s) de 20 €");
        System.out.println(billete10 + " billete(s) de 10 €");
        System.out.println(billete5 + " billete(s) de 5 €");
        System.out.println(moneda2 + " moneda(s) de 2 €");
        System.out.println(moneda1 + " moneda(s) de 1 €");

    }
}
