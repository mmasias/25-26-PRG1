import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos):");
        int precioBaseCentimos = scanner.nextInt();

        System.out.println("Cantidad de unidades:");
        int cantidad = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        int tipoIVA = scanner.nextInt();

        double precioBase = precioBaseCentimos / 100.0;

        double porcentajeDescuento = (cantidad >= 100) ? 15 :
                                    (cantidad >= 50) ? 10 :
                                    (cantidad >= 10) ? 5 : 0;

        double precioConIVA = precioBase * (1 + tipoIVA / 100.0);
        double precioUnitarioFinal = precioConIVA * (1 - porcentajeDescuento / 100.0);
        double precioTotal = precioUnitarioFinal * cantidad;

        System.out.println();
        System.out.println("Precio base: " + precioBase + " $");
        System.out.println("IVA aplicado: " + tipoIVA + " %");
        System.out.println("Descuento aplicado: " + porcentajeDescuento + " %");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + " $");
        System.out.println("Precio total: " + precioTotal + " $");

        scanner.close();
    }
}