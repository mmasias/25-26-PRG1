import java.util.Scanner;

class ConvertorDeSegundos {
    public static void main(String[] args) {

        final int SEGUNDOS_POR_MINUTO = 60;
        final int MINUTOS_POR_HORA = 60;
        final int HORAS_POR_DIA = 24;

    System.out.println("¿Cuantos segundos desea convertir?");
    Scanner scanner = new Scanner(System.in);
    int segundos = scanner.nextInt();

    scanner.close();

    int minutos = segundos / SEGUNDOS_POR_MINUTO;
    segundos = segundos % SEGUNDOS_POR_MINUTO;

    int horas = minutos / MINUTOS_POR_HORA;
    minutos = minutos % MINUTOS_POR_HORA;

    int dias = horas / HORAS_POR_DIA;
    horas = horas % HORAS_POR_DIA;

    System.out.println("Dias: " + dias);
    System.out.println("Horas: " + horas);
    System.out.println("Minutos: " + minutos);
    System.out.println("Segundos: " + segundos);

    }
 }