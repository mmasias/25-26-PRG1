import java.util.Scanner;

class DevolverCambio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuánto cuesta la compra?");
        int precioCompra = scanner.nextInt();

        System.out.println("¿Con qué has pagado?");
        int cantidadPagada = scanner.nextInt();

        final int VALOR_BILLETE_200 = 200;
        final int VALOR_BILLETE_100 = 100;
        final int VALOR_BILLETE_50 = 50;
        final int VALOR_BILLETE_20 = 20;
        final int VALOR_BILLETE_10 = 10;
        final int VALOR_BILLETE_5 = 5;
        final int VALOR_MONEDA_2 = 2;
        final int VALOR_MONEDA_1 = 1;


        int cambio = cantidadPagada - precioCompra;


        String falta = "Faltan" + -(cambio) + " euros";
        String vuelta = "El cambio son " + cambio + " euros";

        String mensaje = (cambio < 0) ? falta : vuelta;
        System.out.println(mensaje);

        int cantidadBilletes200 = cambio / VALOR_BILLETE_200;
        cambio = cambio % VALOR_BILLETE_200;

        int cantidadBilletes100 = cambio / VALOR_BILLETE_100;
        cambio = cambio % VALOR_BILLETE_100;

        int cantidadBilletes50 = cambio / VALOR_BILLETE_50;
        cambio = cambio % VALOR_BILLETE_50;

        int cantidadBilletes20 = cambio / VALOR_BILLETE_20;
        cambio = cambio % VALOR_BILLETE_20;

        int cantidadBilletes10 = cambio / VALOR_BILLETE_10;
        cambio = cambio % VALOR_BILLETE_10;

        int cantidadBilletes5 = cambio / VALOR_BILLETE_5;
        cambio = cambio % VALOR_BILLETE_5;

        int cantidadMonedas2 = cambio / VALOR_MONEDA_2;
        cambio = cambio % VALOR_MONEDA_2;

        int cantidadMonedas1 = cambio / VALOR_MONEDA_1;
        cambio = cambio % VALOR_MONEDA_1;


        String textoBilletes200 = (cantidadBilletes200 > 0) ? cantidadBilletes200 + " billetes de 200 \n" : "";
        String textoBilletes100 = (cantidadBilletes100 > 0) ? cantidadBilletes100 + " billetes de 100 \n" : "";
        String textoBilletes50 = (cantidadBilletes50 > 0) ? cantidadBilletes50 + " billetes de 50 \n" : "";
        String textoBilletes20 = (cantidadBilletes20 > 0) ? cantidadBilletes20 + " billetes de 20 \n" : "";
        String textoBilletes10 = (cantidadBilletes10 > 0) ? cantidadBilletes10 + " billetes de 10 \n" : "";
        String textoBilletes5 = (cantidadBilletes5 > 0) ? cantidadBilletes5 + " billetes de 5 \n" : "";
        String textoMonedas2 = (cantidadMonedas2 > 0) ? cantidadMonedas2 + " monedas de 2 \n" : "";
        String textoMonedas1 = (cantidadMonedas1 > 0) ? cantidadMonedas1 + " monedas de 14" : "";


        String textoFinal = textoBilletes200 + textoBilletes100 + textoBilletes50 + textoBilletes20 + textoBilletes10 + textoBilletes5 + textoMonedas2 + textoMonedas1;


        System.out.print("La vuelta son: \n" + textoFinal);


        scanner.close();
    }

}
