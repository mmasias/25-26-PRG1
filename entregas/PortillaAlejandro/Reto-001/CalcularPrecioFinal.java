import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Precio unitario base (céntimos): ");
        int precioBaseCentimos = lector.nextInt();

        System.out.print("Cantidad de unidades: ");
        int cantidad = lector.nextInt();

        System.out.print("Tipo de IVA (21, 10 o 4): ");
        int iva = lector.nextInt();

        double precioBase = precioBaseCentimos / 100.0;
        double descuento = 0.0;

        // Calcular descuento con if independientes
        if (cantidad >= 10) {
            descuento = 0.05;
        }
        if (cantidad >= 50) {
            descuento = 0.10;
        }
        if (cantidad >= 100) {
            descuento = 0.15;
        }

        double precioConIva = precioBase * (1 + iva / 100.0);
        double precioFinalUnitario = precioConIva * (1 - descuento);
        double precioTotal = precioFinalUnitario * cantidad;

        System.out.println();
        System.out.printf("Precio base: %.2f €%n", precioBase);
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.printf("Precio unitario final: %.2f €%n", precioFinalUnitario);
        System.out.printf("Precio total: %.2f €%n", precioTotal);

        lector.close();
    }
}
