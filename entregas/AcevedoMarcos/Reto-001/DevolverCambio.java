import java.util.Scanner;

public class DevolverCambio {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int pagar, entregado, cambio;
        int billetes100, billetes50, billetes20, billetes10, billetes5, monedas2, monedas1;

        System.out.println("¿Cuántos euros debe pagar?");
        pagar = teclado.nextInt();

        System.out.println("¿Con cuántos euros paga?");
        entregado = teclado.nextInt();

        cambio = entregado - pagar;

        // Cálculo del cambio con operaciones básicas
        billetes100 = cambio / 100;
        cambio = cambio % 100;

        billetes50 = cambio / 50;
        cambio = cambio % 50;

        billetes20 = cambio / 20;
        cambio = cambio % 20;

        billetes10 = cambio / 10;
        cambio = cambio % 10;

        billetes5 = cambio / 5;
        cambio = cambio % 5;

        monedas2 = cambio / 2;
        cambio = cambio % 2;

        monedas1 = cambio; // lo que quede son monedas de 1 €

        // Mostrar resultados
        System.out.println();
        System.out.println(billetes100 + " billete(s) de 100 €");
        System.out.println(billetes50 + " billete(s) de 50 €");
        System.out.println(billetes20 + " billete(s) de 20 €");
        System.out.println(billetes10 + " billete(s) de 10 €");
        System.out.println(billetes5 + " billete(s) de 5 €");
        System.out.println(monedas2 + " moneda(s) de 2 €");
        System.out.println(monedas1 + " moneda(s) de 1 €");

        teclado.close();
    }
}
