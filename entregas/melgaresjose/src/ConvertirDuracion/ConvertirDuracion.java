import java.util.Scanner;

class ConvertirDuracion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int SEGUNDOS_EN_HORA = 3600;
        final int SEGUNDOS_EN_DIA = 86400;
        final int SEGUNDOS_EN_MINUTO = 60;
        final int MINUTOS_EN_HORA = 60;
        final int HORAS_EN_DIA = 60;


        System.out.print("Cuantos segundos desea convertir?: ");
        int segundosTotales = scanner.nextInt(); 


        int segundos = segundosTotales % 60; 
        int minutos = (segundosTotales /60) % 60;
        int horas = (segundosTotales/3600) % 24;
        int dias = (segundosTotales / 86400);
        
        System.out.println(dias + " dia" + (dias > 1 ? "s" : ""));
        System.out.println(horas + " hora" + (horas > 1 ? "s" : ""));
        System.out.println(minutos + " minuto" + (minutos > 1 ? "s" : ""));
        System.out.println(segundos + " segundo" + (segundos > 1 ? "s" : "" ));
    }
}