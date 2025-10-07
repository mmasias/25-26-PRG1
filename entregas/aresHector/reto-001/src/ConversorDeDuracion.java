import java.util.Scanner;

class ConversorDeDuracion {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos segundos quieres convertir?");
        int segundos = scanner.nextInt();
        scanner.close();
        int dias = segundos / 86400;
        segundos = segundos % 86400;
        int horas = segundos / 3600;
        segundos = segundos % 3600;
        int minutos = segundos / 60;
        segundos = segundos % 60;


        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
        System.out.println("Dias: " + dias);
    }
}


