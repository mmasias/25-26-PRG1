import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int precioBaseCentimos;
        int cantidad;
        int iva;
        double precioBaseEuros;
        double descuento = 0;
        double precioConIVA;
        double precioUnitarioFinal;
        double precioTotal;

        // Entrada de datos
        System.out.println("Precio unitario base (céntimos):");
        precioBaseCentimos = teclado.nextInt();

        System.out.println("Cantidad de unidades:");
        cantidad = teclado.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        iva = teclado.nextInt();

        // Conversión a euros
        precioBaseEuros = precioBaseCentimos / 100.0;

        // Calcular descuento según cantidad
        if (cantidad >= 100) {
            descuento = 0.15;
        } else if (cantidad >= 50) {
            descuento = 0.10;
        } else if (cantidad >= 10) {
            descuento = 0.05;
        } else {
            descuento = 0;
        }

        // Aplicar IVA
        precioConIVA = precioBaseEuros + (precioBaseEuros * iva / 100.0);

        // Aplicar descuento
        precioUnitarioFinal = precioConIVA - (precioConIVA * descuento);

        // Calcular precio total
        precioTotal = precioUnitarioFinal * cantidad;

        // Mostrar resultados
        System.out.println();
        System.out.println("Precio base: " + String.format("%.2f", precioBaseEuros) + " €");
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.println("Precio unitario final: " + String.format("%.2f", precioUnitarioFinal) + " €");
        System.out.println("Precio total: " + String.format("%.2f", precioTotal) + " €");

        teclado.close();
    }
}
