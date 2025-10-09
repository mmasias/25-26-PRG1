import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos):");
        int precioBaseCentimos = sc.nextInt();

        System.out.println("Cantidad de unidades:");
        int cantidad = sc.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        int iva = sc.nextInt();

        double precioBase = precioBaseCentimos / 100;

        double descuento = 0;
        if (cantidad >= 100) {
            descuento = 15;
        } else if (cantidad >= 50) {
            descuento = 10;
        } else if (cantidad >= 10) {
            descuento = 5;
        }

        double precioConDescuento = precioBase * (1 - descuento / 100);

        double precioFinalUnitario = precioConDescuento * (1 + iva / 100);

        double precioTotal = precioFinalUnitario * cantidad;

        System.out.println();
        System.out.printf("Precio base: %.2f €%n", precioBase);
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.printf("Precio unitario final: %.2f €%n", precioFinalUnitario);
        System.out.printf("Precio total: %.2f €%n", precioTotal);

        sc.close();
    }
}
