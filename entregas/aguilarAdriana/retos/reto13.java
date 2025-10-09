import java.util.Scanner;

class reto13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Precio unitario base (céntimos):");
        int precioUnitario = scanner.nextInt();
        System.out.println("Cantidad de unidades:");
        int cantidad = scanner.nextInt();
        System.out.println("Tipo de IVA (21, 10 o 4):");
        int iva = scanner.nextInt();

        int descuento = (cantidad >= 100) ? 15 : (cantidad >= 50) ? 10 : (cantidad >= 10) ? 5 : 0;
        int precioConIVA = precioUnitario + (precioUnitario * iva / 100);
        int precioFinalUnitario = precioConIVA - (precioConIVA * descuento / 100);
        int precioTotal = precioFinalUnitario * cantidad;

        System.out.println("Precio base: " + (precioUnitario / 100.0) + " €");
        System.out.println("IVA aplicado: " + iva + "%");
        System.out.println("Descuento aplicado: " + descuento + "%");
        System.out.println("Precio unitario final: " + (precioFinalUnitario / 100.0) + " €");
        System.out.println("Precio total: " + (precioTotal / 100.0) + " €");

        scanner.close();
    }
}