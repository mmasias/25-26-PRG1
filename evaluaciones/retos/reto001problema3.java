import java.text.DecimalFormat;
import java.util.Scanner;


public class reto001problema3 {
    public static void main(String[] args) {
        System.out.println("Precio unitario base:");
        Scanner scanner = new Scanner(System.in);
        int precioUnitarioBase = scanner.nextInt();
        System.out.println("Cantidad de unidades:");
        Scanner scanner2 = new Scanner(System.in);
        int unidades = scanner2.nextInt();
        System.out.println("Tipo de IVA (21,10 O 4)");
        Scanner scanner3 = new Scanner(System.in);
        int iva = scanner3.nextInt();
        double precioBase= precioUnitarioBase/100.0;
        double descuento100uds = 15.00;
        double descuento50uds = 10.00;
        double descuento10uds = 5.00;
        double descuento=0.00;
        if(unidades>=100){
             descuento = descuento100uds;

        }
        else if(unidades>=50){
             descuento= descuento50uds;

        }
        else if(unidades>=10){
             descuento=descuento10uds;
        }
        double aplicacionIva = iva/100;
        double aplicacionDescuento = descuento/100;
        double precioIva = precioBase*aplicacionIva+precioBase;
        double precioUnitatioTotal= precioIva*aplicacionDescuento+precioIva;
        double precioTotal = precioUnitatioTotal*unidades;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Precio base: "+df.format(precioBase));
        System.out.println("IVA aplicado: "+iva+"%");
        System.out.println("Descuento aplicado: "+df.format(descuento)+"%)");
        System.out.println("Precio unitario final: "+df.format(precioUnitatioTotal));
    }
    
}
