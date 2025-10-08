import java.util.Scanner;

public class CalculadoraPrecio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos): ");
        int precioUnitario = scanner.nextInt();

        System.out.println("Cantidad de unidades: ");
        int cantidadUnidades = scanner.nextInt();

        final int DESCUENTO_CINCO_POR_CIENTO = 5;
        final int CANTIDAD_DESCUENTO_CINCO = 10; 
        final int DESCUENTO_DIEZ_POR_CIENTO = 10;
        final int CANTIDAD_DESCUENTO_DIEZ = 50;
        final int DESCUENTO_QUINCE_POR_CIENTO = 15;
        final int CANTIDAD_DESCUENTO_QUINCE = 100;
        final int SIN_DESCUENTO = 0;

        System.out.println("Tipo de IVA (21, 10 o 4): ");
        int tipoIVA = scanner.nextInt();

        int descuento = cantidadUnidades >= CANTIDAD_DESCUENTO_QUINCE ? DESCUENTO_QUINCE_POR_CIENTO : cantidadUnidades >= CANTIDAD_DESCUENTO_DIEZ ? DESCUENTO_DIEZ_POR_CIENTO : cantidadUnidades >= CANTIDAD_DESCUENTO_CINCO ? DESCUENTO_CINCO_POR_CIENTO : SIN_DESCUENTO;
        
        int precioFinal;
        precioFinal = cantidadUnidades*precioUnitario*(100-descuento)/100*(100+tipoIVA)/100;

        System.out.print("Precio base: ");
        System.out.println(precioUnitario);
        System.out.print("El descuento será de: ");
        System.out.println(descuento);
        System.out.print("El tipo de IVA aplicado es: ");
        System.out.println(tipoIVA);
        System.out.print("El precio final es de: ");
        System.out.print(precioFinal);
        System.out.print(" céntimos.");
        
        }
}
