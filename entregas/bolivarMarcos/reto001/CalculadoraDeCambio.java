import java.util.Scanner;
class Primero {
    public static void main(String args[])
    {
        int costo;
        costo = (int)(Math.random() * 100) + 1;
        System.out.println("El total a pagar es: "+ costo);

    Scanner Pago = new Scanner(System.in);
        System.out.println("Ingrese Con cuanto va a pagar: ");
    int ingreso = Pago.nextInt();
    int cambio = ingreso - costo;
        
        if (ingreso >= costo)
        {
            System.out.println("Su cambio es: " + cambio);
            if (cambio > 0) {
                if (cambio >= 50) { System.out.println((cambio/50) + " billete(s) de 50 euro"); cambio = cambio%50; }
                if (cambio >= 20) { System.out.println((cambio/20) + " billete(s) de 20 euro"); cambio = cambio%20; }
                if (cambio >= 10) { System.out.println((cambio/10) + " billete(s) de 10 euro"); cambio = cambio%10; }
                if (cambio >= 5)  { System.out.println((cambio/5)  + " billete(s) de 5 euro");  cambio = cambio%5;  }
                if (cambio >= 2)  { System.out.println((cambio/2)  + " moneda(s) de 2 euro");   cambio = cambio%2;  }
                if (cambio >= 1)  { System.out.println((cambio/1)  + " moneda(s) de 1 euro");   cambio = cambio%1;  }
            }
        }
        else
        {
            System.out.println("No tiene suficiente dinero");
        }
    }
}