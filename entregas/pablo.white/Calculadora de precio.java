import java.util.Scanner;

class CalculadoraDePrecio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos):");
        int precioUnitario = scanner.nextInt();
        double precioBaseEuros = precioUnitario / 100.0;

        System.out.println("Cantidad de unidades:");
        int cantidadProducto = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        int tipoIva = scanner.nextInt();

        int rebaja = cantidadProducto >= 100 ? 15 :
                     cantidadProducto >= 50 ? 10 :
                     cantidadProducto >= 10 ? 5 : 0;

        double precioConIva = precioBaseEuros * (1 + tipoIva / 100.0);
        double precioUnitarioFinal = precioConIva * (1 - rebaja / 100.0);
        double precioTotal = precioUnitarioFinal * cantidadProducto;

        System.out.printf("\nPrecio base: %.2f €\n", precioBaseEuros);
        System.out.printf("IVA aplicado: %d%%\n", tipoIva);
        System.out.printf("Descuento aplicado: %d%%\n", rebaja);
        System.out.printf("Precio unitario final: %.2f €\n", precioUnitarioFinal);
        System.out.printf("Precio total: %.2f €\n", precioTotal);

        scanner.close();
    }
}