import java.util.Scanner;

public class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos segundos desea convertir? ");
        int s = sc.nextInt();

        int dias = s / 86400; s %= 86400;
        int horas = s / 3600; s %= 3600;
        int minutos = s / 60;
        int segundos = s % 60;

        // Mostrar siempre, con singular/plural
        System.out.println(dias + " " + (dias == 1 ? "día" : "días"));
        System.out.println(horas + " " + (horas == 1 ? "hora" : "horas"));
        System.out.println(minutos + " " + (minutos == 1 ? "minuto" : "minutos"));
        System.out.println(segundos + " " + (segundos == 1 ? "segundo" : "segundos"));
    }
}
