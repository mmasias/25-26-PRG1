import java.util.Scanner;

class ConversorSegundos{
    public static void main(String[] args) {
        final int DIAS_EN_SEGUNDOS = 86400;
        final int HORAS_EN_SEGUNDOS =3600;
        final int MINUTOS_EN_SEGUNDOS = 60;

        Scanner scanner = new Scanner(System.in);
        System.out.print(s:"¿Cuantos segundos quieres convertir?");
        int segundosTotales = scanner.nextInt();

        int dias = segundosTotales / DIAS_EN_SEGUNDOS;
        int segundosRestantes = segundosTotales % DIAS_EN_SEGUNDOS;

        int horas = segundosRestantes / HORAS_EN_SEGUNDOS;
        segundosRestantes %= HORAS_EN_SEGUNDOS;

        int minutos = segundosRestantes / MINUTOS_EN_SEGUNDOS;
        int segundos = segundosRestantes % MINUTOS_EN_SEGUNDOS;

        System.out.println(segundosTotales + "segundos son:");
        System.out.println(dias + "días");
        System.out.println(horas + "horas");
        System.out.println(miutos + "minutos");
        System.out.println(segundos + "segundos");

        scanner.close();
    }

}