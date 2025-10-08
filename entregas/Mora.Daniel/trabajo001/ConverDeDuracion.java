import java.util.Scanner;

class ConverDeDuracion {
    public static void main(String[] args) {
        final int DIAS_EN_SEGUNDOS = 86400;
        final int HORAS_EN_SEGUNDOS = 3600;
        final int MINUTOS_EN_SEGUNDOS = 60;
        final int SEGUNDOS = 1;
        final int SEGUNDOS_POR_MINUTO = 60 * SEGUNDOS;
        final int SEGUNDOS_POR_HORA = 60 * SEGUNDOS_POR_MINUTO;
        final int SEGUNDOS_POR_DIA = 24 * SEGUNDOS_POR_HORA;
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos segundos desea convertir?");
        int segundos = scanner.nextInt();
        int dias = segundos / DIAS_EN_SEGUNDOS;
        int horas = (segundos % DIAS_EN_SEGUNDOS) / HORAS_EN_SEGUNDOS;
        int minutos = (segundos % HORAS_EN_SEGUNDOS) / MINUTOS_EN_SEGUNDOS;
        int segundosConvertidos = (segundos % MINUTOS_EN_SEGUNDOS) / SEGUNDOS;
        System.out.println(dias + "dia(s)");
        System.out.println(horas + "hora(s)");
        System.out.println(minutos + "minuto(s)");
        System.out.println(segundosConvertidos + "segundos(s)");
        scanner.close();

    }
}
