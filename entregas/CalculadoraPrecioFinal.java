import java.util.Scanner;

class CalculadoraPrecioFinal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos): ");
        double precioUnitarioBase = scanner.nextDouble() / 100;

        System.out.println("Cantidad de unidades: ");
        int cantidadUnidades = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4): ");
        int tipoIva = scanner.nextInt();

        int NO_HAY_DESCUENTO = 0;
        int DESCUENTO_10_UNIDADES = 5;
        int DESCUENTO_50_UNIDADES = 10;
        int DESCUENTO_100_UNIDADES = 15;

        int porcentajeDescuento = (cantidadUnidades < 10) ? NO_HAY_DESCUENTO : (cantidadUnidades < 50) ? DESCUENTO_10_UNIDADES : (cantidadUnidades < 100) ? DESCUENTO_50_UNIDADES : DESCUENTO_100_UNIDADES;

        double ivaCalculado = precioUnitarioBase * (tipoIva / 100.0);

        double precioConIva = precioUnitarioBase + ivaCalculado;

        double descuentoCalculado = precioConIva * (porcentajeDescuento / 100.0);

        double precioUnitarioFinal = (precioConIva - descuentoCalculado);

        double precioTotal = precioUnitarioFinal * cantidadUnidades;

        String textoPrecioUnitarioBase = "Precio base: " + precioUnitarioBase + "€\n";

        String textoIvaAplicado = "IVA aplicado: " + tipoIva + "%\n";

        String textoDescuentoAplicado = "Descuento aplicado: " + porcentajeDescuento + "%\n";

        String textoPrecioUnitarioFinal = "Precio unitario final: " + precioUnitarioFinal + "€\n";

        String textoPrecioTotal = "Precio total: " + precioTotal + "€\n";

        String textoFinal = textoPrecioUnitarioBase + textoIvaAplicado + textoDescuentoAplicado + textoPrecioUnitarioFinal + textoPrecioTotal;

        System.out.print(textoFinal);

        scanner.close();

    }

}