import java.util.Scanner;

class ConvertidorSegundos {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos segundos desea convertir?");
        
        int segundosUsuario = scanner.nextInt();
        
        int segundosPorDia = 86400;
        int segundosPorHora = 3600;
        int segundosPorMinuto = 60;

        int dias = segundosUsuario / segundosPorDia;
        segundosUsuario = segundosUsuario % segundosPorDia;

        int horas = segundosUsuario / segundosPorHora;
        segundosUsuario = segundosUsuario % segundosPorHora;

        int minutos = segundosUsuario / segundosPorMinuto;
        segundosUsuario = segundosUsuario % segundosPorMinuto;

        System.out.println(dias + " día(s)");
        System.out.println(horas + " hora(s)");
        System.out.println(minutos + " minuto(s)");
        System.out.println(segundosUsuario + " segundo(s)");

       
    }
}