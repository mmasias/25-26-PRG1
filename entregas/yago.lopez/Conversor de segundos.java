import java.util.Scanner;

class ConversorSegundos {
    public static void main(String[] args) {

        final int DIAS_EN_SEGUNDOS = 86400;   // 24 * 60 * 60
        final int HORAS_EN_SEGUNDOS = 3600;   // 60 * 60
        final int MINUTOS_EN_SEGUNDOS = 60;   // 60 segundos

        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántos segundos quieres convertir?: ");
        int segundosTotales = scanner.nextInt();

        int dias = segundosTotales / DIAS_EN_SEGUNDOS;
        int segundosRestantes = segundosTotales % DIAS_EN_SEGUNDOS;

        int horas = segundosRestantes / HORAS_EN_SEGUNDOS;
        segundosRestantes %= HORAS_EN_SEGUNDOS;

        int minutos = segundosRestantes / MINUTOS_EN_SEGUNDOS;
        int segundos = segundosRestantes % MINUTOS_EN_SEGUNDOS;

        System.out.println("\n" + segundosTotales + " segundos son:");
        System.out.println(dias + " días");
        System.out.println(horas + " horas");
        System.out.println(minutos + " minutos");
        System.out.println(segundos + " segundos");

        scanner.close();
    }
}
