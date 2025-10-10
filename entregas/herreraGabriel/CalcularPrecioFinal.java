import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int umbral10 = 10;
        int umbral50 = 50;
        int umbral100 = 100;

        double desc5 = 0.05;
        double desc10 = 0.10;
        double desc15 = 0.15;

        System.out.println("Precio unitario base (céntimos):");
        int precioBaseCent = scanner.nextInt();

        System.out.println("Cantidad de unidades:");
        int cantidad = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        int iva = scanner.nextInt();

        double precioBaseEuro = precioBaseCent / 100.0;
        double precioConIVA = precioBaseEuro * (1 + iva / 100.0);

        double descuento = (cantidad >= umbral100) ? desc15 :
                           (cantidad >= umbral50)  ? desc10 :
                           (cantidad >= umbral10)  ? desc5  : 0.0;

        double precioUnitarioFinal = precioConIVA * (1 - descuento);
        double precioTotal = precioUnitarioFinal * cantidad;

        System.out.println();
        System.out.println("Precio base: " + precioBaseEuro + " euros");
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + " euros");
        System.out.println("Precio total: " + precioTotal + " euros");

        scanner.close();
    }
}
