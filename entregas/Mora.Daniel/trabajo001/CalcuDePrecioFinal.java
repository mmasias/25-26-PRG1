import java.util.Scanner;

class CalcuDePrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int DESCUENTO_DEL_15 = 15;
        final int CANTIDAD_DESCUENTO_15 = 100;
        final int DESCUENTO_DEL_10 = 10;
        final int CANTIDAD_DESCUENTO_10 = 50;
        final int DESCUENTO_DEL_5 = 5;
        final int CANTIDAD_DESCUENTO_5 = 10;

        System.out.println("Introduce el precio base del producto");
        int precioBaseEnCents = scanner.nextInt();

        System.out.println("Introduce el número de unidades");
        int unidadesDelProducto = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4)");
        int tipoIVA = scanner.nextInt();

        int descuento = unidadesDelProducto >= CANTIDAD_DESCUENTO_15 ? DESCUENTO_DEL_15
                : unidadesDelProducto >= CANTIDAD_DESCUENTO_10 ? DESCUENTO_DEL_10
                        : unidadesDelProducto >= CANTIDAD_DESCUENTO_5 ? DESCUENTO_DEL_5 : 0;
        double precioBase = precioBaseEnCents / 100.0;
        double precioConDescuento = precioBase * (1 - descuento / 100.0);
        double precioUnitarioFinal = precioConDescuento * (1 + tipoIVA / 100.0);
        double precioTotal = precioUnitarioFinal * unidadesDelProducto;
        System.out.println("Precio base : " + precioBase + "€");
        System.out.println("IVA aplicado: " + tipoIVA + "%");
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + "€");
        System.out.println("Precio total : " + precioTotal + "€");
        scanner.close();

    }
}
