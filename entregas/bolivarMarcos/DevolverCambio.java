package entregas.bolivarMarcos;

import java.util.Scanner;

public class DevolverCambio {

    public static void main(String[] args) {
        final int BILLETE_100 = 100;
        final int BILLETE_50 = 50;
        final int BILLETE_20 = 20;
        final int BILLETE_10 = 10;
        final int BILLETE_5 = 5;
        final int MONEDA_2 = 2;
        final int MONEDA_1 = 1;

        Scanner entrada = new Scanner(System.in);

        System.out.print("¿Cuántos euros debe pagar? ");
        int cantidadAPagar = entrada.nextInt();

        System.out.print("¿Con cuántos euros paga? ");
        int cantidadPagada = entrada.nextInt();

        int cambio = cantidadPagada - cantidadAPagar;

        int cantidad100 = cambio / BILLETE_100;
        cambio = cambio % BILLETE_100;

        int cantidad50 = cambio / BILLETE_50;
        cambio = cambio % BILLETE_50;

        int cantidad20 = cambio / BILLETE_20;
        cambio = cambio % BILLETE_20;

        int cantidad10 = cambio / BILLETE_10;
        cambio = cambio % BILLETE_10;

        int cantidad5 = cambio / BILLETE_5;
        cambio = cambio % BILLETE_5;

        int cantidad2 = cambio / MONEDA_2;
        cambio = cambio % MONEDA_2;

        int cantidad1 = cambio / MONEDA_1;
        cambio = cambio % MONEDA_1;

        System.out.println();
        System.out.println(cantidad100 + " billete(s) de 100 €");
        System.out.println(cantidad50 + " billete(s) de 50 €");
        System.out.println(cantidad20 + " billete(s) de 20 €");
        System.out.println(cantidad10 + " billete(s) de 10 €");
        System.out.println(cantidad5 + " billete(s) de 5 €");
        System.out.println(cantidad2 + " moneda(s) de 2 €");
        System.out.println(cantidad1 + " moneda(s) de 1 €");

    }
}
