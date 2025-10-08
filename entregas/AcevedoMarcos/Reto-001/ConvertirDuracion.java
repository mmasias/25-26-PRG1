import java.util.Scanner;

public class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int segundosTotales;
        int dias, horas, minutos, segundos;

        System.out.println("¿Cuántos segundos desea convertir?");
        segundosTotales = teclado.nextInt();

        // Cálculos básicos
        dias = segundosTotales / 86400;
        segundosTotales = segundosTotales % 86400;

        horas = segundosTotales / 3600;
        segundosTotales = segundosTotales % 3600;

        minutos = segundosTotales / 60;
        segundos = segundosTotales % 60;

        // Mostrar resultado con formato elegante (singular/plural)
        System.out.println();

        if (dias == 1) {
            System.out.println(dias + " día");
        } else {
            System.out.println(dias + " días");
        }

        if (horas == 1) {
            System.out.println(horas + " hora");
        } else {
            System.out.println(horas + " horas");
        }

        if (minutos == 1) {
            System.out.println(minutos + " minuto");
        } else {
            System.out.println(minutos + " minutos");
        }

        if (segundos == 1) {
            System.out.println(segundos + " segundo");
        } else {
            System.out.println(segundos + " segundos");
        }

        teclado.close();
    }
}
