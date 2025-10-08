import java.util.Scanner;

class Problema2 {
    public static void main(String[] args) {

    System.out.println("¿Cuantos segundos desea convertir?");
    Scanner scanner = new Scanner(System.in);
    int segundos = scanner.nextInt();

    scanner.close();

    int minutos = segundos / 60;
    segundos = segundos % 60;

    int horas = minutos / 60;
    minutos = minutos % 60;

    int dias = horas / 24;
    horas = horas % 24;

    System.out.println("Dias: " + dias);
    System.out.println("Horas: " + horas);
    System.out.println("Minutos: " + minutos);
    System.out.println("Segundos: " + segundos);

    }
 }