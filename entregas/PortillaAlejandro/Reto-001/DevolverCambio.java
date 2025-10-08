import java.util.Scanner;

public class DevolverCambio {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Cuántos euros debe pagar? ");
        int pagar = lector.nextInt();

        System.out.print("¿Con cuántos euros paga? ");
        int paga = lector.nextInt();

        int cambio = paga - pagar;

        System.out.println();
        System.out.println("Cambio total: " + cambio + " €");
        System.out.println();

        int billetes100 = cambio / 100;
        cambio = cambio % 100;

        int billetes50 = cambio / 50;
        cambio = cambio % 50;

        int billetes20 = cambio / 20;
        cambio = cambio % 20;

        int billetes10 = cambio / 10;
        cambio = cambio % 10;

        int billetes5 = cambio / 5;
        cambio = cambio % 5;

        int monedas2 = cambio / 2;
        cambio = cambio % 2;

        int monedas1 = cambio / 1;
        cambio = cambio % 1;

        System.out.println(billetes100 + " billete(s) de 100 €");
        System.out.println(billetes50 + " billete(s) de 50 €");
        System.out.println(billetes20 + " billete(s) de 20 €");
        System.out.println(billetes10 + " billete(s) de 10 €");
        System.out.println(billetes5 + " billete(s) de 5 €");
        System.out.println(monedas2 + " moneda(s) de 2 €");
        System.out.println(monedas1 + " moneda(s) de 1 €");

        lector.close();
    }
}
