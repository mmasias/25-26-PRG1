import java.util.Scanner;

public class CambioDeDinero {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos euros debe pagar?");
        int montoApagar = scanner.nextInt();
        System.out.println("¿Cuántos euros ha entregado?");
        int montoEntregado = scanner.nextInt();

        int cambio = montoEntregado - montoApagar;
        int nuevoCambio;
        System.out.println("cambio " + cambio + " EUR");

        final int billete_100 = 100;
        final int billete_50 = 50;
        final int billete_20 = 20;
        final int billete_10 = 10;
        final int billete_5 = 5;
        final int m2 = 2;
        final int m1 = 1;

        int cantidad = cambio / billete_100;
        nuevoCambio = cambio % billete_100;
        System.out.println("billete_100: " + cantidad);

        cantidad = nuevoCambio / billete_50;
        nuevoCambio = nuevoCambio % billete_50;
        System.out.println("billete_50: " + cantidad);

        cantidad = nuevoCambio / billete_20;
        nuevoCambio = nuevoCambio % billete_20;
        System.out.println("billete_20: " + cantidad);

        cantidad = nuevoCambio / billete_10;
        nuevoCambio = nuevoCambio % billete_10;
        System.out.println("billete_10: " + cantidad);

        cantidad = nuevoCambio / billete_5;
        nuevoCambio = nuevoCambio % billete_5;
        System.out.println("billete_5: " + cantidad);

        cantidad = nuevoCambio / m2;
        nuevoCambio = nuevoCambio % m2;
        System.out.println("m2: " + cantidad);

        cantidad = nuevoCambio / m1;
        nuevoCambio = nuevoCambio % m1;
        System.out.println("m1: " + cantidad);

        scanner.close();

    }
}
