
import java.util.Scanner;

public class ConversorDeDuracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int SEGUNDOS_DEL_DIA = 24 * 60 * 60;
        final int SEGUNDO_DE_HORA = 60 * 60;
        final int SEGUNDOS_DE_MINUTO = 60;

        System.out.println("¿Cuántos segundos desea convertir?");
        int segundos = scanner.nextInt();

        int dias = segundos / SEGUNDOS_DEL_DIA;

        segundos = segundos % SEGUNDOS_DEL_DIA;

        int horas = segundos / SEGUNDO_DE_HORA;

        segundos = segundos % SEGUNDO_DE_HORA;

        int minutos = segundos / SEGUNDOS_DE_MINUTO;

        segundos = segundos % SEGUNDOS_DE_MINUTO;

        System.out.println(dias + " dia" + (dias > 1 ? "s" : ""));
        System.out.println(horas + " hora" + (horas > 1 ? "s" : ""));
        System.out.println(minutos + " minuto" + (minutos > 1 ? "s" : ""));
        System.out.println(segundos + " segundo" + (segundos > 1 ? "s" : ""));
    }

}