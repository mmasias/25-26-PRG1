import java.util.Scanner;

class DevolverCambio {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int eurosAPagar;
        int eurosRecibidos;
        int billetes100,
            billetes50,
            billetes20,
            billetes10,
            billetes5,
            monedas2,
            monedas1;
        System.out.print("¿Cuántos euros debe de pagar?: ");
        eurosAPagar = scr.nextInt();
        System.out.print("¿Con cuántos euros paga?: ");
        eurosRecibidos = scr.nextInt();
        int cambio = eurosAPagar - eurosRecibidos;
        cambio *= (cambio < 0) ? -1 : 1;
        int cambioOriginal = cambio;
        
        billetes100 = cambio / 100;
        cambio = cambio % 100;
        billetes50 = cambio % 100 / 50;
        cambio = cambio % 50;
        billetes20 = cambio / 20;
        cambio = cambio % 20;
        billetes10 = cambio / 10;
        cambio = cambio % 10;
        billetes5 = cambio / 5;
        cambio = cambio % 5;
        monedas2 = cambio / 2; 
        monedas1 = cambio %2;
        
        System.out.println("Su cambio total es de " + cambioOriginal);
        System.out.println(billetes100 + " billete(s) de 100 euros");
        System.out.println(billetes50 + " billete(s) de 50 euros");
        System.out.println(billetes20 + " billete(s) de 20 euros");
        System.out.println(billetes10 + " billete(s) de 10 euros");
        System.out.println(billetes5 + " billete(s) de 5 euros");
        System.out.println(monedas2 + " moneda(s) de 2 euros");
        System.out.println(monedas1 + " moneda(s) de 1 euros");
        
    }
}