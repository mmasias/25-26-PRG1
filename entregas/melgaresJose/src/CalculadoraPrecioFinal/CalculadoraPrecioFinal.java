import java.util.Scanner;

public class CalculadoraPrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int precioCentimos, unidades;
        double tipoIVA;

        System.out.println("Precio unitario base (céntimos) ");
        precioCentimos = scanner.nextInt();
        System.out.println("Cantidad de unidades: ");
        unidades  = scanner.nextInt();
        System.out.println("Tipo de IVA (21, 10 o 4): ");
        tipoIVA = scanner.nextInt();
        tipoIVA = tipoIVA * 0.01 + 1;

        double precioBase = precioCentimos / 100;
        double descuento;
        descuento = (unidades >= 10) ? 0.95 : 1;
        descuento = (unidades >= 50) ? 0.9 : descuento;
        descuento = (unidades >= 100) ? 0.85 : descuento;

        double precioUnitarioFinal = tipoIVA * descuento * precioBase;
        double totalPago = precioUnitarioFinal * unidades;
        System.out.println("Precio base: " + precioBase + " euros");
        System.out.println("IVA aplicado: " + 100*(tipoIVA-1) + "%");
        System.out.println("Descuento aplicado: " + 100*(1 - descuento) + "%");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + " euros");
        System.out.println("Precio total:" + totalPago + " euros");
    }
}