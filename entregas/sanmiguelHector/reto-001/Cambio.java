import java.util.Scanner;

class Cambio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuánto es la vuelta?");

        int vuelta = scanner.nextInt();

        final int VALOR_BILLETE_DE_DOSCIENTOS = 200;
        final int VALOR_BILLETE_DE_CIEN = 100;
        final int VALOR_BILLETE_DE_CINCUENTA = 50;
        final int VALOR_BILLETE_DE_VEINTE = 20;
        final int VALOR_BILLETE_DE_DIEZ = 10;
        final int VALOR_BILLETE_DE_CINCO = 5;
        final int VALOR_MONEDA_DE_DOS = 2;
        final int VALOR_MONEDA_DE_UNO = 1;

        int BilletesDoscientos;
        BilletesDoscientos = vuelta / VALOR_BILLETE_DE_DOSCIENTOS;
        int nuevaVuelta;
        nuevaVuelta = vuelta % VALOR_BILLETE_DE_DOSCIENTOS;

        int BilletesCien;
        BilletesCien = nuevaVuelta / VALOR_BILLETE_DE_CIEN;
        nuevaVuelta = nuevaVuelta % VALOR_BILLETE_DE_CIEN;

        int BilletesCincuenta;
        BilletesCincuenta = nuevaVuelta / VALOR_BILLETE_DE_CINCUENTA;
        nuevaVuelta = nuevaVuelta % VALOR_BILLETE_DE_CINCUENTA;

        int BilletesVeinte;
        BilletesVeinte = nuevaVuelta / VALOR_BILLETE_DE_VEINTE;
        nuevaVuelta = nuevaVuelta % VALOR_BILLETE_DE_VEINTE;

        int BilletesDiez;
        BilletesDiez = nuevaVuelta / VALOR_BILLETE_DE_DIEZ;
        nuevaVuelta = nuevaVuelta % VALOR_BILLETE_DE_DIEZ;

        int BilletesCinco;
        BilletesCinco = nuevaVuelta / VALOR_BILLETE_DE_CINCO;
        nuevaVuelta = nuevaVuelta % VALOR_BILLETE_DE_CINCO;

        int MonedasDos;
        MonedasDos = nuevaVuelta / VALOR_MONEDA_DE_DOS;
        nuevaVuelta = nuevaVuelta % VALOR_MONEDA_DE_DOS;

        String mensajeFinal;
        mensajeFinal = "Se devuelven:\n";
        mensajeFinal = BilletesDoscientos > 0 ? BilletesDoscientos + " billete(s) de 200\n" : "";
        mensajeFinal = mensajeFinal + (BilletesCien > 0 ? BilletesCien + " billete de 100\n": "");
        mensajeFinal = mensajeFinal + (BilletesCincuenta > 0 ? BilletesCincuenta + " billete de 50\n": "");
        mensajeFinal = mensajeFinal + (BilletesVeinte > 0 ? BilletesVeinte + " billete(s) de 20\n": "");
        mensajeFinal = mensajeFinal + (BilletesDiez > 0 ? BilletesDiez + " billete de 10\n": "");
        mensajeFinal = mensajeFinal + (BilletesCinco > 0 ? BilletesCinco + " billete de 5\n": "");
        mensajeFinal = mensajeFinal + (MonedasDos > 0 ? MonedasDos + " moneda(s) de 2\n": "");
        mensajeFinal = mensajeFinal + (nuevaVuelta > 0 ? nuevaVuelta + " moneda de 1\n": "");


        System.out.println(mensajeFinal);

        scanner.close();
    }
}