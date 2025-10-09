package evaluaciones.retos;

import java.util.Scanner;

public class DevolucionCambio {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       System.out.println("¿Cuantos euros debe pagar?");
       int euros=scanner.nextInt();
       System.out.println("¿Cuantos euros paga?");
       int eurosRecibidos=scanner.nextInt();

         int cambio=eurosRecibidos-euros;
         int billetes=cambio/100;
         int resto=cambio%100;
         System.out.println(billetes+" billetes de 100");
            billetes=resto/50;
            resto=resto%50;
            System.out.println(billetes+" billetes de 50");
            billetes=resto/20;
            resto=resto%20;
            System.out.println(billetes+" billetes de 20");
            billetes=resto/10;
            resto=resto%10;
            System.out.println(billetes+" billetes de 10");
            billetes=resto/5;
            resto=resto%5;
            System.out.println(billetes+" monedas de 5");
            billetes=resto/2;
            resto=resto%2;
            System.out.println(billetes+" monedas de 2");
            
            System.out.println(billetes+" monedas de 1");


    }
}