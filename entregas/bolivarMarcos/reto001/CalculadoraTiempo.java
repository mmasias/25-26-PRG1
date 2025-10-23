
import java.util.Scanner;

class CalculadoraTiempo {

    public static void main(String args[]) {

        int segundos;
        int minutos;
        int horas;
        int dias;

        final int SEGUNDOS_POR_MINUTO = 60;
        final int MINUTOS_POR_HORA = 60;
        final int HORAS_POR_DIA = 24;

        Scanner imput = new Scanner(System.in);
        System.out.println("Cantidad de segundos a convertir: ");
        segundos = imput.nextInt();

        minutos = segundos / SEGUNDOS_POR_MINUTO;
        horas = minutos / MINUTOS_POR_HORA;
        dias = horas / HORAS_POR_DIA;

        minutos = minutos >= MINUTOS_POR_HORA ? minutos % MINUTOS_POR_HORA : minutos;
        horas = horas >= HORAS_POR_DIA ? horas % HORAS_POR_DIA : horas;
        segundos = segundos >= SEGUNDOS_POR_MINUTO ? segundos % SEGUNDOS_POR_MINUTO : segundos;

        System.out.println("Equivalente a: " + dias + " dia(s), " + horas + " hora(s), " + minutos + " minuto(s) y " + segundos + " segundo(S).");

    }
}
