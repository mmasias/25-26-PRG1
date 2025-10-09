import java.util.Scanner;

public class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuántos segundos desea convertir?");
        int segundos = sc.nextInt();

        int dias = segundos / 86400;
        segundos %= 86400;

        int horas = segundos / 3600;
        segundos %= 3600;

        int minutos = segundos / 60;
        segundos %= 60;

        System.out.println();
        System.out.println(dias + (dias == 1 ? " día" : " días"));
        System.out.println(horas + (horas == 1 ? " hora" : " horas"));
        System.out.println(minutos + (minutos == 1 ? " minuto" : " minutos"));
        System.out.println(segundos + (segundos == 1 ? " segundo" : " segundos"));

        sc.close();
    }
}
