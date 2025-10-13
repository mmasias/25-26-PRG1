import java.util.Scanner;

class CalculadoraDePrecio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Precio unitario base (en céntimos): ");
        int precioBaseCents = scanner.nextInt();

        System.out.print("Cantidad de unidades: ");
        int unidades = scanner.nextInt();

        System.out.print("Tipo de IVA (21, 10 o 4): ");
        int tipoIva = scanner.nextInt();

        double precioBaseEuros = precioBaseCents / 100.0;
        double tasaIva = tipoIva / 100.0;
        double precioConIva = precioBaseEuros * (1 + tasaIva);

        double tasaDescuento = 0.0;
        if (unidades >= 100) {
            tasaDescuento = 0.15;
        } else if (unidades >= 50) {
            tasaDescuento = 0.10;
        } else if (unidades >= 10) {
            tasaDescuento = 0.05;
        }

        double precioUnitarioFinal = precioConIva * (1 - tasaDescuento);
        double precioTotalFinal = precioUnitarioFinal * unidades;

        System.out.printf("\nPrecio base: %.2f €\n", precioBaseEuros);
        System.out.println("IVA aplicado: " + tipoIva + "%");
        System.out.println("Descuento aplicado: " + (int)(tasaDescuento * 100) + "%");
        System.out.printf("Precio unitario final: %.2f €\n", precioUnitarioFinal);
        System.out.printf("Precio total: %.2f €\n", precioTotalFinal);

        scanner.close();
    }
}