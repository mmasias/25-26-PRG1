package asier_reto1;


import java.util.Scanner;

public class Asier_reto1 {


  
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Ingresa el precio del producto:");
     int precio = input.nextInt();

    System.out.println("Ingresa el dinero entregado:");
      int pago = input.nextInt();

        int cambio = pago - precio;
        System.out.println("El cambio es: $" + cambio);


        int[] valores = {100,50, 20, 10, 5, 2, 1};
        String[] nombres = {
            "billete de 100","billete de 50", "billete de 20", "billete de 10",
            "billete de 5", "moneda de 2", "moneda de 1" };

        System.out.println("\nDesglose del cambio:");
        
        for (int i = 0; i < valores.length; i++) {
            int cantidad = cambio / valores[i];
            if (cantidad > 0) {
                System.out.println(cantidad + " × " + nombres[i]);
                cambio %= valores[i];
            }
        }

        input.close();
    }
}