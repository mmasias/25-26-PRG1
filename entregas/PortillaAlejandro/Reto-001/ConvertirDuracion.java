import java.util.Scanner;

public class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("¿Cuántos segundos desea convertir? ");
        int totalSegundos = lector.nextInt();

        int dias = totalSegundos / 86400;
        totalSegundos = totalSegundos % 86400;

        int horas = totalSegundos / 3600;
        totalSegundos = totalSegundos % 3600;

        int minutos = totalSegundos / 60;
        int segundos = totalSegundos % 60;

        System.out.println();
        System.out.println(dias + " día(s)");
        System.out.println(horas + " hora(s)");
        System.out.println(minutos + " minuto(s)");
        System.out.println(segundos + " segundo(s)");

        lector.close();
    }
}
