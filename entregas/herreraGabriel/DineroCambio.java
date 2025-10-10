import java.util.Scanner;

public class DineroCambio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Para que se vea mejor pon 4 en precio total y 213102392  cuanto pagas");
        System.out.println("Introduce el precio total (en euros): ");
        int precio = scanner.nextInt();

        System.out.println("Introduce con cuánto pagas (en euros): ");
        int pago = scanner.nextInt();

        int cambio = pago - precio;

        System.out.println(
                (cambio < 0) ? "El pago no es suficiente."
                        : (cambio == 0) ? "No hay cambio que devolver." : "Cambio total: " + cambio + " euros");

        System.out.println((cambio > 0) ? "Desglose:" : "");
        System.out.println("---------------------------------------------------");

        int b200 = (cambio > 0) ? cambio / 200 : 0;
        cambio = (b200 > 0) ? cambio % 200 : cambio;
        System.out.println((b200 > 0) ? b200 + " billete(s) de 200 euros" : "");

        System.out.println("---------------------------------------------------");

        int b100 = (cambio > 0) ? cambio / 100 : 0;
        cambio = (b100 > 0) ? cambio % 100 : cambio;
        System.out.println((b100 > 0) ? b100 + " billete(s) de 100 euros" : "");
        System.out.println("---------------------------------------------------");

        int b50 = (cambio > 0) ? cambio / 50 : 0;
        cambio = (b50 > 0) ? cambio % 50 : cambio;
        System.out.println((b50 > 0) ? b50 + " billete(s) de 50 euros" : "");
        System.out.println("---------------------------------------------------");

        int b20 = (cambio > 0) ? cambio / 20 : 0;
        cambio = (b20 > 0) ? cambio % 20 : cambio;
        System.out.println((b20 > 0) ? b20 + " billete(s) de 20 euros" : "");
        System.out.println("---------------------------------------------------");

        int b10 = (cambio > 0) ? cambio / 10 : 0;
        cambio = (b10 > 0) ? cambio % 10 : cambio;
        System.out.println((b10 > 0) ? b10 + " billete(s) de 10 euros" : "");
        System.out.println("---------------------------------------------------");

        int b5 = (cambio > 0) ? cambio / 5 : 0;
        cambio = (b5 > 0) ? cambio % 5 : cambio;
        System.out.println((b5 > 0) ? b5 + " billete(s) de 5 euros" : "");
        System.out.println("---------------------------------------------------");

        int m2 = (cambio > 0) ? cambio / 2 : 0;
        cambio = (m2 > 0) ? cambio % 2 : cambio;
        System.out.println((m2 > 0) ? m2 + " moneda(s) de 2 euros" : "");
        System.out.println("---------------------------------------------------");

        int m1 = (cambio > 0) ? cambio / 1 : 0;
        cambio = (m1 > 0) ? cambio % 1 : cambio;
        System.out.println((m1 > 0) ? m1 + " moneda(s) de 1 euro" : "");
        System.out.println("---------------------------------------------------");

        scanner.close();
    }
}