import java.util.Scanner;

class CalculadoraDePrecio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Precio unitario (en céntimos): ");
        int precioUnitario = scanner.nextInt();
        double precioEnEuros = precioUnitario / 100.0;

        System.out.print("Cantidad de artículos: ");
        int cantidadDeArticulos = scanner.nextInt();

        System.out.print("Tipo de IVA (21, 10, 4): ");
        int tipoDeIva = scanner.nextInt();

        int rebaja = cantidadDeArticulos >= 100 ? 15 :
                     cantidadDeArticulos >= 50  ? 10 :
                     cantidadDeArticulos >= 10  ? 5 : 0;

        double precioConIva = precioEnEuros * (1 + tipoDeIva / 100.0);
        double precioTotalAntesDescuento = precioConIva * cantidadDeArticulos;
        double importeRebaja = precioTotalAntesDescuento * rebaja / 100.0;
        double precioFinal = precioTotalAntesDescuento - importeRebaja;

        System.out.println();
        System.out.println("----- Desglose -----");
        System.out.println("Precio por unidad (EUR): " + precioEnEuros);
        System.out.println("Precio unidad (con IVA): " + precioConIva);
        System.out.println("Cantidad: " + cantidadDeArticulos);
        System.out.println("IVA aplicado: " + tipoDeIva + "%");
        System.out.println("Descuento aplicado: " + rebaja + "%");
        System.out.println("Precio total antes de descuento: " + precioTotalAntesDescuento + " €");
        System.out.println("Importe de la rebaja: " + importeRebaja + " €");
        System.out.println("Precio final a pagar: " + precioFinal + " €");

    scanner.close();
    }
}
