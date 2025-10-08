import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos
        System.out.print("Precio unitario base (céntimos): ");
        int precioBaseCts = sc.nextInt();

        System.out.print("Cantidad de unidades: ");
        int cantidad = sc.nextInt();

        System.out.print("Tipo de IVA (21, 10 o 4): ");
        int iva = sc.nextInt();

        // Convertir precio base a euros
        double precioBase = precioBaseCts / 100.0;

        // Calcular descuento con if sencillos
        double descuento = 0;
        if (cantidad >= 10) descuento = 5;
        if (cantidad >= 50) descuento = 10;
        if (cantidad >= 100) descuento = 15;

        // Aplicar descuento
        double precioConDescuento = precioBase * (1 - descuento / 100.0);

        // Aplicar IVA
        double precioUnitarioFinal = precioConDescuento * (1 + iva / 100.0);

        // Precio total
        double precioTotal = precioUnitarioFinal * cantidad;

        // Mostrar resultados
        System.out.printf("Precio base: %.2f €%n", precioBase);
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + (int)descuento + "%");
        System.out.printf("Precio unitario final: %.2f €%n", precioUnitarioFinal);
        System.out.printf("Precio total: %.2f €%n", precioTotal);
    }
}
