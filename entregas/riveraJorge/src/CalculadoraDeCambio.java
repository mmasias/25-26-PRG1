import java.util.Scanner;


public class CalculadoraDeCambio {
    

    public static void main(String[] args) {
       
        
            Scanner scanner = new Scanner(System.in);
            final int BILLETE_DE_100 = 100;
            final int BILLETE_DE_50 = 50;
            final int BILLETE_DE_20 = 20;
            final int BILLETE_DE_10 = 10;
            final int BILLETE_DE_5 = 5;
            final int MONEDA_DE_2 = 2;
            final int MONEDA_DE_1 = 1;
            
            System.out.println ("Cuanto debe pagar?");
           int cantidadDebida = scanner.nextInt();
           System.out.println ("Con cuanto va a pagar?");
           int cantidadPagada = scanner.nextInt();
           
           int cambio = cantidadPagada - cantidadDebida;
           int billetes100 = cambio / BILLETE_DE_100;
           cambio = cambio % 100;
           int billetes50 = cambio / BILLETE_DE_50;
           cambio = cambio % 50;
           int billetes20 = cambio / BILLETE_DE_20;
           cambio = cambio % 20;
           int billetes10 = cambio / BILLETE_DE_10;
           cambio = cambio % 10;
           int billetes5 = cambio / BILLETE_DE_5;
           cambio = cambio % 5;
           int monedas2 = cambio / MONEDA_DE_2;
           cambio = cambio % 2;
           int monedas1 = cambio / MONEDA_DE_1;
           cambio = cambio % 1;
           
           System.out.println("Su cambio es  ");
           System.out.println(billetes100 + " billete(s) de 100 euros");
           System.out.println(billetes50 + " billete(s) de 50 euros");
           System.out.println(billetes20 + " billete(s) de 20 euros");
           System.out.println(billetes10 + " billete(s) de 10 euros");
           System.out.println(billetes5 + " billete(s) de 5 euros");
           System.out.println(monedas2 + " moneda(s) de 2 euros");
           System.out.println(monedas1 + " moneda(s) de 1 euro");
    }

}