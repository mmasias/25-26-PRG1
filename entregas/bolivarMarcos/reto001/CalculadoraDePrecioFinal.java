import java.util.Scanner;
public class CalculadoraDePrecioFinal {
    
    public static void main(String[] args) {
        
        final int DESCUENTO_MAS_DE_10= 5;
        final int DESCUENTO_MAS_DE_50= 10;
        final int DESCUENTO_MAS_DE_100= 15;

        int PrecioUnitarioBase;
        int IVA;
        double PrecioBase;
        int cantidad;
        double PrecioDescontado;
        double PrecioFinal;
        double PrecioUnitarioFinal;

        PrecioUnitarioBase = (int) (Math.random() * 10000 + 100);

        System.out.println("El precio unitario base del producto es de "+ PrecioUnitarioBase + " cts.");
        Scanner imput = new Scanner(System.in);
            System.out.print("¿Que cantidad de artículos va a comprar?: ");
            cantidad = imput.nextInt();

          
       
        System.out.println("Que cantidad de IVA tiene el producto (4, 10 o 21)?: ");
        IVA = imput.nextInt();

        PrecioBase= PrecioUnitarioBase/100.0;

          PrecioDescontado= (cantidad>=100)? PrecioBase* (1-DESCUENTO_MAS_DE_100/100.0):
                          (cantidad>=50)? PrecioBase* (1-DESCUENTO_MAS_DE_50/100.0):
                          (cantidad>=10)? PrecioBase* (1-DESCUENTO_MAS_DE_10/100.0):
                          PrecioBase;
        PrecioUnitarioFinal = PrecioDescontado * (1 + IVA/100.0);
        PrecioFinal= PrecioUnitarioFinal* cantidad;

        System.out.println("El precio base es de : "+ PrecioBase+ " euros.");
        System.out.println("El IVA aplicado es de : "+ IVA + " %.");
        System.out.println("El descuento aplicado es de : "+ (int)((1-(PrecioDescontado/PrecioBase))*100) + " %.");
        System.out.println("El precio unitario final es de: "+ PrecioUnitarioFinal + " euros.");
        System.out.println("El precio final es de: "+ PrecioFinal + " euros.");



    }
}
