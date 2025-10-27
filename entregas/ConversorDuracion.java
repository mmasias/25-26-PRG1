import java.util.Scanner;

public class ConversorDuracion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la duración en segundos: ");
        int segundosTotales = scanner.nextInt();

        String resultado = convertirDuracion(segundosTotales);
        System.out.println("Resultado: " + resultado);

        scanner.close();
    }

    public static String convertirDuracion(int segundosTotales) {
        int dias = segundosTotales / 86400;
        segundosTotales %= 86400;

        int horas = segundosTotales / 3600;
        segundosTotales %= 3600;

        int minutos = segundosTotales / 60;
        int segundos = segundosTotales % 60;

        return String.format("%s, %s, %s y %s",
            formato(dias, "día", "días"),
            formato(horas, "hora", "horas"),
            formato(minutos, "minuto", "minutos"),
            formato(segundos, "segundo", "segundos")
        );
    }

    public static String formato(int valor, String singular, String plural) {
        return valor + " " + (valor == 1 ? singular : plural);
    }
}