
import java.util.Scanner;

public class CalcularPrecioFinal {

    public static void main(String[] args) {
        final int CANTIDAD_DESCUENTO_5 = 10;
        final int CANTIDAD_DESCUENTO_10 = 50;
        final int CANTIDAD_DESCUENTO_15 = 100;

        final double DESCUENTO_5 = 0.05;
        final double DESCUENTO_10 = 0.10;
        final double DESCUENTO_15 = 0.15;
        final double SIN_DESCUENTO = 0.00;

        Scanner entrada = new Scanner(System.in);

        int precioBaseCentimos = (int) (Math.random() * (3000 - 1000 + 1)) + 1000;

        int[] posiblesIVA = {4, 10, 21};
        int tipoIVA = posiblesIVA[(int) (Math.random() * posiblesIVA.length)];

        System.out.print("Cantidad de unidades: ");
        int cantidadUnidades = entrada.nextInt();

        double precioBaseEuros = precioBaseCentimos / 100.0;

        double descuentoAplicado = cantidadUnidades >= CANTIDAD_DESCUENTO_15 ? DESCUENTO_15
                : cantidadUnidades >= CANTIDAD_DESCUENTO_10 ? DESCUENTO_10
                        : cantidadUnidades >= CANTIDAD_DESCUENTO_5 ? DESCUENTO_5
                                : SIN_DESCUENTO;

        double precioConDescuento = precioBaseEuros * (1 - descuentoAplicado);
        double precioUnitarioFinal = precioConDescuento * (1 + tipoIVA / 100.0);
        double precioTotalFinal = precioUnitarioFinal * cantidadUnidades;

        System.out.println();
        System.out.println("Precio base (aleatorio): " + precioBaseEuros + " €");
        System.out.println("IVA aplicado (aleatorio): " + tipoIVA + "%");
        System.out.println("Descuento aplicado: " + (descuentoAplicado * 100) + "%");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + " €");
        System.out.println("Precio total: " + precioTotalFinal + " €");

    }
}
