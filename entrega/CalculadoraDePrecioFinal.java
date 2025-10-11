import java.util.Scanner;

public class CalculadoraDePrecioFinal {
     public static void main(String[] args){
        Scanner scanner = new  Scanner(System.in);

        final int  TIPO_DE_IVA_MAXIMO = 21;
        final int  TIPO_DE_IVA_INTERMEDIO = 10;
        final int  TIPO_DE_IVA_MINIMO = 4;
        final int  TIPO_DE_DESCUENTO_DE_CINCO = 5;
        final int  TIPO_DE_DESCUENTO_DE_DIEZ = 10;
        final int  TIPO_DE_DESCUENTO_DE_QUINCE = 15;
        final int  CANTIDAD_DE_DIEZ = 10;
        final int  CANTIDAD_DE_CINCUENTA = 50;
        final int  CANTIDAD_DE_CIEN = 100;
        final int CIEN_PORCIENTO = 100;
       
        System.out.print("Precio unitario base(centimos): ");
        int precioUnitarioBaseCentimos = scanner.nextInt();

        System.out.println("Cantidad de unidades: ");
        int cantidadDeUnidades=scanner.nextInt();

        System.out.println("Tipo de IVA (21, 10 o 4): ");
        int ivaIntroducido=scanner.nextInt();


            ivaIntroducido = ivaIntroducido == TIPO_DE_IVA_MAXIMO ? TIPO_DE_IVA_MAXIMO :
            (ivaIntroducido == TIPO_DE_IVA_INTERMEDIO ? TIPO_DE_IVA_INTERMEDIO :
            (ivaIntroducido == TIPO_DE_IVA_MINIMO ? TIPO_DE_IVA_MINIMO : -1));

        double iva = CIEN_PORCIENTO / ivaIntroducido  ;

        System.out.println(iva);

        String mensaje = (ivaIntroducido == TIPO_DE_IVA_MAXIMO) ? "IVA aplicado: 21%" :
                 (ivaIntroducido == TIPO_DE_IVA_INTERMEDIO) ? "IVA aplicado: 10%" :
                 (ivaIntroducido == TIPO_DE_IVA_MINIMO) ? "IVA aplicado: 4%" :
                 "Tipo de IVA no válido";


            int descuento = cantidadDeUnidades >= CANTIDAD_DE_CIEN ? TIPO_DE_DESCUENTO_DE_QUINCE :
            (cantidadDeUnidades >= CANTIDAD_DE_CINCUENTA ? TIPO_DE_DESCUENTO_DE_DIEZ :
            (cantidadDeUnidades >= CANTIDAD_DE_CIEN  ?TIPO_DE_DESCUENTO_DE_CINCO : -1));


        double precioUnitarioBase =  precioUnitarioBaseCentimos / CIEN_PORCIENTO;
        double total = precioUnitarioBase + (precioUnitarioBase * iva );

        double precioUnitarioFinal = total - (descuento * total);

        System.out.println("Precio base: " + precioUnitarioBase + "$");
        System.out.println(mensaje);
        System.out.println("Precio unitario final: " + total + "$");
 

     }
}
