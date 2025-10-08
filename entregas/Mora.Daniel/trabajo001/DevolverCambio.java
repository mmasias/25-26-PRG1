import java.util.Scanner;

class DevolverCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int BILLETES_DE_100 = 100;
        final int BILLETES_DE_50 = 50;
        final int BILLETES_DE_20 = 20;
        final int BILLETES_DE_10 = 10;
        final int BILLETES_DE_5 = 5;
        final int MONEDAS_DE_2 = 2;
        final int MONEDAS_DE_1 = 1;

        System.out.println("¿Cuántos euros debe pagar?");
        int precio = scanner.nextInt();

        System.out.println("¿Con cuántos euros paga?");
        int cantidadDePago = scanner.nextInt();

        int cambio;
        cambio = cantidadDePago - precio;

        System.out.println("Cambio total: " + cambio + " €");

        int billetes100 = cambio / BILLETES_DE_100;
        cambio = cambio % BILLETES_DE_100;

        int billetes50 = cambio / BILLETES_DE_50;
        cambio = cambio % BILLETES_DE_50;

        int billetes20 = cambio / BILLETES_DE_20;
        cambio = cambio % BILLETES_DE_20;

        int billetes10 = cambio / BILLETES_DE_10;
        cambio = cambio % BILLETES_DE_10;

        int billetes5 = cambio / BILLETES_DE_5;
        cambio = cambio % BILLETES_DE_5;

        int monedas2 = cambio / MONEDAS_DE_2;
        cambio = cambio % MONEDAS_DE_2;

        int monedas1 = cambio / MONEDAS_DE_1;
        cambio = cambio % MONEDAS_DE_1;

        System.out.println(billetes100 + " billete(s) de 100 €");
        System.out.println(billetes50 + " billete(s) de 50 €");
        System.out.println(billetes20 + " billete(s) de 20 €");
        System.out.println(billetes10 + " billete(s) de 10 €");
        System.out.println(billetes5 + " billete(s) de 5 €");
        System.out.println(monedas2 + " moneda(s) de 2 €");
        System.out.println(monedas1 + " moneda(s) de 1 €");

        scanner.close();
    }
}
