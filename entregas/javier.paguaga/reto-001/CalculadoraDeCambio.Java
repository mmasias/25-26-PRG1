import java.util.Scanner;

class CalculadoraDeCambio {
    public static void main(String[] args) {

    System.out.println("Cuantos euros debe pagar");
    Scanner scanner = new Scanner(System.in);
    int dineroPorPagar = scanner.nextInt();

    System.out.println("Cuantos euros esta paga");
    int dineroPagado = scanner.nextInt();

    scanner.close();

    int dineroPorDevolver = dineroPagado - dineroPorPagar;

    int billetesDeCien = dineroPorDevolver / 100;
    dineroPorDevolver = dineroPorDevolver % 100;

    int billetesDeCincuenta = dineroPorDevolver / 50;
    dineroPorDevolver = dineroPorDevolver % 50;

    int billetesDeVeinte = dineroPorDevolver / 20;
    dineroPorDevolver = dineroPorDevolver % 20;

    int billetesDeDiez = dineroPorDevolver / 10;
    dineroPorDevolver = dineroPorDevolver % 10;

    int billetesDeCinco = dineroPorDevolver / 5;
    dineroPorDevolver = dineroPorDevolver % 5;

    int monedasDeDos = dineroPorDevolver / 2;
    dineroPorDevolver = dineroPorDevolver % 2;

    System.out.println("Billetes de 100: " + billetesDeCien);
    System.out.println("Billetes de 50: " + billetesDeCincuenta);
    System.out.println("Billetes de 20: " + billetesDeVeinte);
    System.out.println("Billetes de 10: " + billetesDeDiez);
    System.out.println("Billetes de 5: " + billetesDeCinco);
    System.out.println("Monedas de 2: " + monedasDeDos);
    System.out.println("Monedas de 1: " + dineroPorDevolver);

    }
 }