import java.util.Scanner;

public class reto12 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la duracion en segundos:");
        int numero = scanner.nextInt();

        int dia = numero / 86400;
        numero = numero % 86400;
        int hora = numero / 3600;
        numero = numero % 3600;
        int minuto = numero / 60;
        numero = numero % 60;
        int segundos = numero;
        numero = numero;

        System.out.println(dia + " dia" + (dia >= 2 ? "s" : ""));
        System.out.println(hora + " hora" + (hora >= 2 ? "s" : ""));
        System.out.println(minuto + " minuto" + (minuto >= 2 ? "s" : ""));
        System.out.println(segundos + " segundo" + (segundos >= 2 ? "s" : ""));
        scanner.close();
       

       
       

       

    }
}
