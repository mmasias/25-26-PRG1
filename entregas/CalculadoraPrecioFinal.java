import java.util.Scanner;

class CalculadoraPrecioFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Precio unitario base (céntimos):");
        double precioObjetoCentimos = scanner.nextDouble();
        double porcentaje = 100;
        double precioObjetoEuros = precioObjetoCentimos / porcentaje;

        System.out.println("Cantidad de unidades:");
        int unidadesObjeto = scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4):");
        double tipoIVA = scanner.nextDouble();
        tipoIVA = tipoIVA / porcentaje;
        double descuento = unidadesObjeto >= 100 ? 15 : unidadesObjeto >= 50 ? 10 : unidadesObjeto >= 10 ? 5 : 0;
        descuento = descuento / porcentaje;

        double precioIVA = precioObjetoEuros * tipoIVA;
        double precioDescuento = precioObjetoEuros * descuento;
        double precioObjetoFinal = precioObjetoEuros + precioIVA - precioDescuento;
        double precioTotal = precioObjetoFinal * unidadesObjeto;

        System.out.println("Precio Base: " + precioObjetoEuros + " €");
        System.out.println("IVA aplicado: " + tipoIVA * porcentaje + " %");
        System.out.println("Número de objetos: " + unidadesObjeto);
        System.out.println("Descuento aplicado: " + descuento * porcentaje + " %");
        System.out.println("Precio unitario final: " + precioObjetoFinal);
        System.out.println("Precio total: " + precioTotal);

    }
}
