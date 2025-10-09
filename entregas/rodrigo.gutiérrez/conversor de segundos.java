import java.util.Scanner;

class ConversorSegundos {

    public static void main(String[] args) {
        final int DIAS_EN_SEGUNDOS = 86400;
        final int HORAS_EN_SEGUNDOS = 3600;
        final int MINUTOS_EN_SEGUNDOS = 60;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número de segundos a convertir: ");
        int segundos = scanner.nextInt();

        int dias = segundos / DIAS_EN_SEGUNDOS;
        segundos = segundos % DIAS_EN_SEGUNDOS;

        int horas = segundos / HORAS_EN_SEGUNDOS;
        segundos = segundos % HORAS_EN_SEGUNDOS;

        int minutos = segundos / MINUTOS_EN_SEGUNDOS;
        segundos = segundos % MINUTOS_EN_SEGUNDOS;

        System.out.println();
        System.out.println("Resultado:");
        System.out.println("Días: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);

        scanner.close();
    }
}
