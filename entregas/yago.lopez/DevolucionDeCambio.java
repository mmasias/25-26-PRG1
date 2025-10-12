import java.util.Scanner;

class DevolucionCambio {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

   
    final int BILLETE_100 = 100;
    final int BILLETE_50 = 50;
    final int BILLETE_20 = 20;
    final int BILLETE_10 = 10;
    final int BILLETE_5 = 5;
    final int MONEDA_2 = 2;
    final int MONEDA_1 = 1;
    

    System.out.print("¿Cuánto dinero tienes que pagar? ");
    int dineroAPagar = scanner.nextInt();
    
    System.out.print("¿Con cuánto vas a pagar? ");
    int dineroUtilizado = scanner.nextInt();


    int cambio = dineroUtilizado - dineroAPagar;
    System.out.println("\nEl cambio total es: " + cambio + " €");


    int billetes100 = cambio / BILLETE_100;
    cambio = cambio % BILLETE_100;

    int billetes50 = cambio / BILLETE_50;
    cambio = cambio % BILLETE_50;

    int billetes20 = cambio / BILLETE_20;
    cambio = cambio % BILLETE_20;

    int billetes10 = cambio / BILLETE_10;
    cambio = cambio % BILLETE_10;

    int billetes5 = cambio / BILLETE_5;
    cambio = cambio % BILLETE_5;

    int monedas2 = cambio / MONEDA_2;
    cambio = cambio % MONEDA_2;

    int monedas1 = cambio;

   
    System.out.println("\n--- cambio ---");
    System.out.println("Billetes de 100: " + billetes100);
    System.out.println("Billetes de 50: " + billetes50);
    System.out.println("Billetes de 20: " + billetes20);
    System.out.println("Billetes de 10: " + billetes10);
    System.out.println("Billetes de 5: " + billetes5);
    System.out.println("Monedas de 2: " + monedas2);
    System.out.println("Monedas de 1: " + monedas1);

    scanner.close();
  }
}
