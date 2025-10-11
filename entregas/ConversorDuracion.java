import java.util.Scanner;

class ConversorDuracion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Escribe la cantidad de tiempo total en segundos: ");
        int cantidadSegundos = scanner.nextInt();

        final int SEGUNDOS_DIA = 86400;
        final int SEGUNDOS_HORA = 3600;
        final int SEGUNDOS_MINUTO = 60;

        int cantidadDias = cantidadSegundos / SEGUNDOS_DIA;
        cantidadSegundos = cantidadSegundos % SEGUNDOS_DIA;

        int cantidadHoras = cantidadSegundos / SEGUNDOS_HORA;
        cantidadSegundos = cantidadSegundos % SEGUNDOS_HORA;

        int cantidadMinutos = cantidadSegundos / SEGUNDOS_MINUTO;
        cantidadSegundos = cantidadSegundos % SEGUNDOS_MINUTO;

        String textoDias = cantidadDias < 1 ? "" : cantidadDias < 2 ? cantidadDias + " dia\n" : cantidadDias + " dias\n";
        String textoHoras = cantidadHoras < 1 ? "" : cantidadHoras < 2 ? cantidadHoras + " hora\n" : cantidadHoras + " horas\n";
        String textoMinutos = cantidadMinutos < 1 ? "" : cantidadMinutos < 2 ? cantidadMinutos + " minuto\n" : cantidadMinutos + " minutos\n";
        String textoSegundos = cantidadSegundos < 1 ? "" : cantidadSegundos < 2 ? cantidadSegundos + " segundo\n" : cantidadSegundos + " segundos\n";


        String textoFinal = textoDias + textoHoras + textoMinutos + textoSegundos;

        System.out.print(textoFinal);

        scanner.close();

    }

}
