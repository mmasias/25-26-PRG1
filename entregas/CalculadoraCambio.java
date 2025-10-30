
import java.util.Scanner;

public class CalculadoraCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos euros debe pagar?");
        int debe = scanner.nextInt();

        System.out.println("¿Con cuántos euros paga?");
        int paga = scanner.nextInt();

        int vuelta = paga - debe;
        int resto = vuelta % 100;
        int cociente = vuelta / 100;
        System.out.println(cociente + " billete(s) de 100 euros");

        cociente = resto / 50;
        resto = resto % 50;
        System.out.println(cociente + " billete(s) de 50 euros");

        cociente = resto / 20;
        resto = resto % 20;
        System.out.println(cociente + " billete(s) de 20 euros");

        cociente = resto / 10;
        resto = resto % 10;
        System.out.println(cociente + " billete(s) de 10 euros");

        cociente = resto / 5;
        resto = resto % 5;
        System.out.println(cociente + " billete(s) de 5 euros");

        cociente = resto / 2;
        resto = resto % 2;
        System.out.println(cociente + " moneda(s) de 2 euros");

        System.out.println(resto + " moneda(s) de 1 euros");
    }

}
