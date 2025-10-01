import java.util.Scanner;

class DevolverCambio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos euros debe pagar?");
        double precio = scanner.nextDouble();

        System.out.println("Con cuantos euros paga?");
        double cantidaEntregada = scanner.nextDouble();

        scanner.close();

        double cambio = cantidaEntregada - precio;

        int billetesCien = (int) (cambio / 100);
        cambio = cambio % 100;
        int billetesCincuenta = (int) (cambio / 50);
        cambio = cambio % 50;
        int billetesVeinte = (int) (cambio / 20);
        cambio = cambio % 20;
        int billetesDiez = (int) (cambio / 10);
        cambio = cambio % 10;
        int billetesCinco = (int) (cambio / 5);
        cambio = cambio % 5;
        int monedasDos = (int) (cambio / 2);
        cambio = cambio % 2;
        int monedasUno = (int) (cambio / 1);

        
        System.out.println("billetes de 100: " + billetesCien);
        System.out.println("billetes de 50: " + billetesCincuenta);
        System.out.println("billetes de 20: " + billetesVeinte);
        System.out.println("billetes de 10: " + billetesDiez);
        System.out.println("billetes de 5: " + billetesCinco);
        System.out.println("monedas de 2: " + monedasDos);
        System.out.println("monedas de 1: " + monedasUno);
        
    }
}
