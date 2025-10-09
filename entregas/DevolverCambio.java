import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuál es la cantidad de dinero a pagar?");
        int coste = scanner.nextInt();

        System.out.println("¿Cuánto dinero es entregado?");
        int dineroPagado = scanner.nextInt();

        if (dineroPagado < coste) {
            System.out.println("El dinero entregado no es suficiente.");
            return; // Termina el programa
        }

        int cambio = dineroPagado - coste;

        int billetes200 = cambio / 200;
        cambio %= 200;

        int billetes100 = cambio / 100;
        cambio %= 100;

        int billetes50 = cambio / 50;
        cambio %= 50;

        int billetes20 = cambio / 20;
        cambio %= 20;

        int billetes10 = cambio / 10;
        cambio %= 10;

        int billetes5 = cambio / 5;
        cambio %= 5;

        int monedas2 = cambio / 2;
        cambio %= 2;

        int monedas1 = cambio;

        System.out.println("Cambio total: " + (dineroPagado - coste) + "€");
        System.out.println("Se devuelve:");
        System.out.println(billetes200 + " billete(s) de 200€");
        System.out.println(billetes100 + " billete(s) de 100€");
        System.out.println(billetes50 + " billete(s) de 50€");
        System.out.println(billetes20 + " billete(s) de 20€");
        System.out.println(billetes10 + " billete(s) de 10€");
        System.out.println(billetes5 + " billete(s) de 5€");
        System.out.println(monedas2 + " moneda(s) de 2€");
        System.out.println(monedas1 + " moneda(s) de 1€");

        scanner.close();
    }
}
