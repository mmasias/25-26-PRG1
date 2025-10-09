package evaluaciones.retos;

import java.util.Scanner;

public class CalculadoraDePrecio {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("¿Precio unitario base (centimos)?");
        double precioUnitario=scanner.nextDouble();
        System.out.println("¿Cantidad de unidades?");
        int unidades=scanner.nextInt();
        System.out.println("¿Tipo de IVA (21, 10 O 4?");
        int iva=scanner.nextInt();

        precioUnitario=precioUnitario/100;
        System.out.println("Precio unitario base: "+precioUnitario+" euros");
        System.out.println("IVA aplicado: "+iva+"%");
        double descuento=0;
        descuento=(unidades<10?0:(unidades<50?0.05:(unidades<100?0.10:0.15)));
        System.out.println("Descuento aplicado: "+(descuento*100+"%"));
        double precioUnitarioFinal=precioUnitario+(precioUnitario*iva/100);
        System.out.println("Precio unitario con IVA: "+precioUnitarioFinal+" euros");

        precioUnitarioFinal=precioUnitarioFinal-(precioUnitarioFinal*descuento);
        System.out.println("Precio unitario final: "+precioUnitarioFinal+" euros");

        System.out.println("Precio total: "+(precioUnitarioFinal*unidades)+" euros");

}
}   