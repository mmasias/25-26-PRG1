import java.util.Scanner;

class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Cuantos segundos desea convertir?: ");
        int segundosTotales = scr.nextInt(); 
        int segundos = segundosTotales % 60; 
        int minutos = (segundosTotales /60) % 60;
        int horas = (segundosTotales/3600) % 60;
        int dias = (segundosTotales / 86400 ) % 24;
        System.out.println(dias + " dia" + (dias > 1 ? "s" : ""));
        System.out.println(horas + " hora" + (horas > 1 ? "s" : ""));
        System.out.println(minutos + " minuto" + (minutos > 1 ? "s" : ""));
        System.out.println(segundos + " segundo" + (segundos > 1 ? "s" : ""));
    }
}