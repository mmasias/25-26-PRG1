package entregas.bolivarMarcos;

import java.util.Scanner;

public class CalculadoraTiempo {

    public static void main(String[] args) {
        final int SEGUNDOS_POR_DIA = 86400;
        final int SEGUNDOS_POR_HORA = 3600;
        final int SEGUNDOS_POR_MINUTO = 60;

        Scanner entrada = new Scanner(System.in);

        System.out.print("¿Cuántos segundos desea convertir? ");
        int segundosTotales = entrada.nextInt();

        int dias = segundosTotales / SEGUNDOS_POR_DIA;
        int restoDespuesDias = segundosTotales % SEGUNDOS_POR_DIA;

        int horas = restoDespuesDias / SEGUNDOS_POR_HORA;
        int restoDespuesHoras = restoDespuesDias % SEGUNDOS_POR_HORA;

        int minutos = restoDespuesHoras / SEGUNDOS_POR_MINUTO;
        int segundos = restoDespuesHoras % SEGUNDOS_POR_MINUTO;

        String textoDia = dias == 1 ? "día" : "días";
        String textoHora = horas == 1 ? "hora" : "horas";
        String textoMinuto = minutos == 1 ? "minuto" : "minutos";
        String textoSegundo = segundos == 1 ? "segundo" : "segundos";

        System.out.println();
        System.out.println(dias + " " + textoDia);
        System.out.println(horas + " " + textoHora);
        System.out.println(minutos + " " + textoMinuto);
        System.out.println(segundos + " " + textoSegundo);

    }
}
