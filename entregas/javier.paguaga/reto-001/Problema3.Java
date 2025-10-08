import java.util.Scanner;

class Problema3 {
    public static void main(String[] args) {

    System.out.println("Escriba el precio unitario base del producto (centimos)");
    Scanner scanner = new Scanner(System.in);
    int precio = scanner.nextInt();

    System.out.println("¿Cuantos unidades esta comprado?");
    int unidades = scanner.nextInt();

    System.out.println("¿Que tipo de IVA? (21, 10, 4)");
    int IVA = scanner.nextInt();

    scanner.close();

    int descuento = unidades >= 100 ? 15 : unidades >= 50 ? 10 : unidades >= 10 ? 5 : 0;

    int precioConIVA = precio + (precio * IVA / 100);
    int precioUnitarioFinal = precioConIVA - (precioConIVA * descuento / 100);
    int precioTotal = precioUnitarioFinal * unidades;

    System.out.println("Precio base: " + precio + " €");
    System.out.println("IVA aplicado: " + IVA + " %");
    System.out.println("Descuento aplicado: " + descuento + " %");
    System.out.println("Precio unitario final: " + precioUnitarioFinal + " €");
    System.out.println("Precio total: " + precioTotal + " €");

    }
 }