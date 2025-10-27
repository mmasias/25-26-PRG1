import java.util.Scanner;

public class PrecioFinal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Precio base (en céntimos): ");
        int precioBase = sc.nextInt();

        System.out.print("Categoría de IVA (1 = general, 2 = reducido, 3 = superreducido): ");
        int tipoIVA = sc.nextInt();

        System.out.print("Cantidad de unidades: ");
        int cantidad = sc.nextInt();

        // IVA según categoría
        double iva = 0.21;
        if (tipoIVA == 2) iva = 0.10;
        else if (tipoIVA == 3) iva = 0.04;

        // Descuento según cantidad
        double descuento = 0;
        if (cantidad >= 100) descuento = 0.15;
        else if (cantidad >= 50) descuento = 0.10;
        else if (cantidad >= 10) descuento = 0.05;

        // Cálculo de precios
        double precioConIVA = precioBase * (1 + iva);
        double precioFinalUnitario = precioConIVA * (1 - descuento);
        double precioTotal = precioFinalUnitario * cantidad;

        // Mostrar resultados
        System.out.printf("Precio unitario final: %.2f €%n", precioFinalUnitario / 100);
        System.out.printf("Precio total final: %.2f €%n", precioTotal / 100);

        sc.close();
    }
}