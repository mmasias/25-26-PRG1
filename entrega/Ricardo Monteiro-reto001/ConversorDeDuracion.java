import java.util.Scanner;

public class ConversorDeDuracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la duración en segundos: ");
        int totalSegundos = scanner.nextInt();

         final int DIAS_EN_SEGUNDOS = 86400;
         final int HORAS_EN_SEGUNDOS = 3600;
         final int MINUTOS_EN_SEGUNDOS = 60;

        int dias = totalSegundos / DIAS_EN_SEGUNDOS;
        int horas = totalSegundos / HORAS_EN_SEGUNDOS;
        int minutos = (totalSegundos % HORAS_EN_SEGUNDOS) / MINUTOS_EN_SEGUNDOS;
        int segundos = totalSegundos % MINUTOS_EN_SEGUNDOS;

        System.out.println("Duración: "+ dias + "dia(s)" + horas + " hora(s), " + minutos + " minuto(s), " + segundos + " segundo(s)");
        scanner.close();
    }

}