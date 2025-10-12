import java.util.Scanner;

public class CalculadoraPrecio {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int precioCentimos, unidades;
        double tipoIVA;

        System.out.println("Precio unitario base (céntimos) ");
        precioCentimos = scr.nextInt();
        System.out.println("Cantidad de unidades: ");
        unidades  = scr.nextInt();
        System.out.println("Tipo de IVA (21, 10 o 4): ");
        tipoIVA = scr.nextInt();
        tipoIVA = tipoIVA * 0.01 + 1;

        double precioBase = precioCentimos / 100;
        double descuento;
        descuento = (unidades >= 10) ? 0.95 : 1;
        descuento = (unidades >= 50) ? 0.9 : descuento;
        descuento = (unidades >= 100) ? 0.85 : descuento;

        double precioUnitarioFinal = tipoIVA * descuento * precioBase;
        double totalPago = precioUnitarioFinal * unidades;
        System.out.println("Precio base: " + precioBase + " €");
        System.out.println("IVA : " + 100*(1-tipoIVA) + "%");
        System.out.println("Descuento : " + 100*(1 - descuento) + "%");
        System.out.println("Precio unitario final: " + precioUnitarioFinal + " €");
        System.out.println("Precio total:" + totalPago + "€");
    }
}
