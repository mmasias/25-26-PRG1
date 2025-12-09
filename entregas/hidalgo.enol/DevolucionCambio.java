import java.util.Scanner;

class DevolucionCambio {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int Billete_100= 100;
    final int Billete_50 = 50;
    final int Billete_20 = 20;
    final int Billete_10 = 10;
    final int Billete_5 = 5;
    final int Moneda_2 = 2;
    final int Moneda_1= 1;
    
    System.out.print("¿Cuanto dinero debes pagar?");
    int DineroAPagar = scanner.nextInt();
    System.out.print("¿Con cuanto pagarás?");
    int DineroUtilizado = scanner.nextInt();

    int Cambio = DineroUtilizado - DineroAPagar;

    if (Cambio < 0) {
      System.out.println("Te falta por pagar");
    } else if (Cambio == 0) {
      System.out.println("No hay cambio para devolver.");
    } else {
      System.out.println("El cambio a devolver es: " + Cambio + " euros.");

      int Billetes100 = Cambio / Billete_100;
      Cambio %= Billete_100;

      int Billetes50 = Cambio / Billete_50;
      Cambio %= Billete_50;

      int Billetes20 = Cambio / Billete_20;
      Cambio %= Billete_20;

      int Billetes10 = Cambio / Billete_10;
      Cambio %= Billete_10;

      int Billetes5 = Cambio / Billete_5;
      Cambio %= Billete_5;

      int Monedas2 = Cambio / Moneda_2;
      Cambio %= Moneda_2;

      int Monedas1 = Cambio / Moneda_1;
      Cambio %= Moneda_1;

      System.out.println("Billetes de 100 euros: " + Billetes100);
      System.out.println("Billetes de 50 euros: " + Billetes50);
      System.out.println("Billetes de 20 euros: " + Billetes20);
      System.out.println("Billetes de 10 euros: " + Billetes10);
      System.out.println("Billetes de 5 euros: " + Billetes5);
      System.out.println("Monedas de 2 euros: " + Monedas2);
      System.out.println("Monedas de 1 euro: " + Monedas1);

    
    }
  scanner.close();
  }
}