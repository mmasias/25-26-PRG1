
import java.util.Scanner;

public class CalculadoraDePrecioFinal {
    public static void main(String[] args) {
        final double GENERAL = 0.21;
        final double REDUCIDO = 0.1;
        final double SUPER_REDUCIDO = 0.04;
        final double DESCUENTO1 = 0;
        final double DESCUENTO2 = 0.05;
        final double DESCUENTO3 = 0.1;
        final double DESCUENTO4 = 0.15;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Precio unitario base (céntimos):");
        int centimos = scanner.nextInt();

        System.out.println("Cantidad de unidades:");
        int unidades = scanner.nextInt();

        System.out.println("Tipo de IVA (21,10 o 4)");
        int iva = scanner.nextInt();

        double euros = centimos / 100;

        System.out.println("Precio base: " + euros + " €");
        System.out.println("IVA aplicado: " + iva + "%");

        double descuento = 0;
        
        descuento = unidades < 10 ? DESCUENTO1: (unidades < 50 ? DESCUENTO2 : (unidades < 100 ? DESCUENTO3 : DESCUENTO4));
        System.out.println("Descuento aplicado: " + descuento * 100 + "%");
        double unitario = euros + euros * iva / 100;
        unitario = unitario - descuento * unitario;

        System.out.println("Precio unitario final: " + unitario + " €");

        double total = unitario * unidades;
        System.out.println("Precio total: " + total + " €");

    }
}
