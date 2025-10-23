 import java.util.Scanner;
 class CalculadoraDeCambio{

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cantidad de dinero a pagar: ");
        int dineroPorPagar = scanner.nextInt();

        System.out.println("Cantidad de dinero que se paga: ");
        int dineroEntregado = scanner.nextInt();

        int dineroDevuelto = dineroEntregado - dineroPorPagar;

        int billetes200 = dineroDevuelto / 200;
        dineroDevuelto = dineroDevuelto % 200;

        int billetes100 = dineroDevuelto / 100;
        dineroDevuelto = dineroDevuelto % 100;

        int billetes50 = dineroDevuelto / 50;
        dineroDevuelto = dineroDevuelto % 50;

        int billetes20 = dineroDevuelto / 20;
        dineroDevuelto = dineroDevuelto % 20;

        int billetes10 = dineroDevuelto / 10;
        dineroDevuelto = dineroDevuelto % 10;

        int billetes5 = dineroDevuelto / 5;
        dineroDevuelto = dineroDevuelto % 5;

        int monedas2 = dineroDevuelto / 2;
        dineroDevuelto = dineroDevuelto % 2;    

        int monedas1 = dineroDevuelto / 1;
        dineroDevuelto = dineroDevuelto % 1;

        System.out.println("Billetes de 200: " + billetes200);
        System.out.println("Billetes de 100: " + billetes100);
        System.out.println("Billetes de 50: " + billetes50);
        System.out.println("Billetes de 20: " + billetes20);
        System.out.println("Billetes de 10: " + billetes10);
        System.out.println("Billetes de 5: " + billetes5);
        System.out.println("Monedas de 2: " + monedas2);
        System.out.println("Monedas de 1: " + monedas1);
    }
 }