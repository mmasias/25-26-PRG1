import java.util.Scanner;

class Conversor {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Cuantos segundos desea convertir?: ");
        int Tsegundos = scr.nextInt(); 
        int segundos = Tsegundos % 60; 
        int minutos = (Tsegundos /60) % 60;
        int horas = (Tsegundos/3600) % 60;
        int dias = (Tsegundos / 86400 ) % 24;
        System.out.println(dias + " dia" + (dias > 1 ? "s" : ""));
        System.out.println(horas + " hora" + (horas > 1 ? "s" : ""));
        System.out.println(minutos + " minuto" + (minutos > 1 ? "s" : ""));
        System.out.println(segundos + " segundo" + (segundos > 1 ? "s" : ""));
    }
}
