import java.util.Scanner;

class reto11 {
    public static void main(String[] args) {
        System.out.println("¿Cuantos euros debe pagar?");
        Scanner scanner = new Scanner(System.in);
        int euros = scanner.nextInt();
        System.out.println("¿Cuanto ha entregado?");
        int eurosEntregados = scanner.nextInt();
        int cambio = eurosEntregados - euros;
        int billetesDe100,
            billetesDe50,
            billetesDe20,
            billetesDe10,
            billetesDe5,
            monedasDe2,
            monedasDe1;

        billetesDe100 = cambio / 100;
        cambio = cambio % 100;   
        billetesDe50 = cambio / 50;
        cambio = cambio % 50;
        billetesDe20 = cambio / 20;
        cambio = cambio % 20;
        billetesDe10 = cambio / 10;
        cambio = cambio % 10;
        billetesDe5 = cambio / 5;
        cambio = cambio % 5;
        monedasDe2 = cambio / 2;
        cambio = cambio % 2;
        monedasDe1 = cambio; 

        System.out.println("Debe devolver:");
        System.out.println(billetesDe100 + " billetes de 100");
        System.out.println(billetesDe50 + " billetes de 50");
        System.out.println(billetesDe20 + " billetes de 20");
        System.out.println(billetesDe10 + " billetes de 10");
        System.out.println(billetesDe5 + " billetes de 5");
        System.out.println(monedasDe2 + " monedas de 2");
        System.out.println(monedasDe1 + " monedas de 1");
        scanner.close();
    }
}


