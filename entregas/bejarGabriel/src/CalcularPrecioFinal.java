import java.util.Scanner;
public class CalcularPrecioFinal {
    public static void main(String[] args) {
        int precioBaseCentimos, cantidad, tipoIVA;
        double ivaPorcentaje, descuentoPorcentaje = 0;
        int precioConIVA, precioUnitarioFinalCentimos;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Precio unitario base (céntimos): ");
        precioBaseCentimos = entrada.nextInt();
        System.out.print("Cantidad de unidades: ");
        cantidad = entrada.nextInt();
        System.out.print("Tipo de IVA (21, 10 o 4): ");
        tipoIVA = entrada.nextInt();
        if (tipoIVA == 21) {
            ivaPorcentaje = 0.21;
            System.out.println("Precio base: " + (precioBaseCentimos / 100.0) + " €");
            System.out.println("IVA aplicado: 21%");
        } else if (tipoIVA == 10) {
            ivaPorcentaje = 0.10;
            System.out.println("Precio base: " + (precioBaseCentimos / 100.0) + " €");
            System.out.println("IVA aplicado: 10%");
        } else {
            ivaPorcentaje = 0.04;
            System.out.println("Precio base: " + (precioBaseCentimos / 100.0) + " €");
            System.out.println("IVA aplicado: 4%");
        }
        if (cantidad >= 100) {
            descuentoPorcentaje = 0.15;
            System.out.println("Descuento aplicado: 15%");
        } else if (cantidad >= 50) {
            descuentoPorcentaje = 0.10;
            System.out.println("Descuento aplicado: 10%");
        } else if (cantidad >= 10) {
            descuentoPorcentaje = 0.05;
            System.out.println("Descuento aplicado: 5%");
        } else {
            System.out.println("Descuento aplicado: 0%");
        }
        precioConIVA = (int) (precioBaseCentimos * (1 + ivaPorcentaje));
        int descuentoCentimos = (int) (precioConIVA * descuentoPorcentaje);
        precioUnitarioFinalCentimos = precioConIVA - descuentoCentimos;
        double unitarioFinalEuros = precioUnitarioFinalCentimos / 100.0;
        double totalEuros = unitarioFinalEuros * cantidad;
        System.out.printf("Precio unitario final: %.2f €%n", unitarioFinalEuros);
        System.out.printf("Precio total: %.2f €%n", totalEuros);
        entrada.close();
    }
}