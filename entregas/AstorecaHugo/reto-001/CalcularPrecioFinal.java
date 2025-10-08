import java.util.Scanner;

public class CalcularPrecioFinal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        
        final int DESCUENTO_DE_5 = 5;
        final int CANTIDAD_DESCUENTO_5 = 10;
        final int DESCUENTO_DE_10 = 10;
        final int CANTIDAD_DESCUENTO_10 = 50;
        final int DESCUENTO_DE_15 = 15;
        final int CANTIDAD_DESCUENTO_15 =100;

        System.out.println("Introduce el precio base del producto (en céntimos):");
        int precioCentimos = teclado.nextInt();
        System.out.println("¿Cuántas unidades va a comprar?");
        int cantidadProducto = teclado.nextInt();
        System.out.println("Tipo de IVA (21,10 o 4)");
        int tipoIVA = teclado.nextInt();

        int descuento = cantidadProducto >= CANTIDAD_DESCUENTO_15 ? DESCUENTO_DE_15
                        : cantidadProducto >= CANTIDAD_DESCUENTO_10 ? DESCUENTO_DE_10
                        : cantidadProducto >= CANTIDAD_DESCUENTO_5 ? DESCUENTO_DE_5
                        : 0;


        double precioInicial = precioCentimos / 100.0;
        double precioSinDescuento = precioInicial * cantidadProducto;
        double precioConDescuento = precioSinDescuento - (precioSinDescuento * descuento / 100);
        double precioFinal = precioConDescuento * (1 + tipoIVA / 100.0);
        double precioTotal = precioFinal * cantidadProducto;

        System.out.println ("Precio inicial :" + precioInicial + "€");
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("IVA aplicado: " + tipoIVA + "%");
        System.out.println("Precio total : " + precioFinal + "€");
        teclado.close();
    }
}

    

