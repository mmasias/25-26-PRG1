import java.util.Scanner;


public class reto001problema2 {
    public static void main(String[] args) {
        System.out.println("¿Cuántos segundos deseas convertir?");
            Scanner scanner = new Scanner(System.in);
            int totalSegundos = scanner.nextInt();
            int segundosPorDia = 86400;
            int segundosPorHora = 3600;
            int segundosPorMinuto = 60;
            int dias = totalSegundos/segundosPorDia;
            totalSegundos= totalSegundos%segundosPorDia;
            int horas = totalSegundos/segundosPorHora;
            totalSegundos= totalSegundos%segundosPorHora;
            int minutos = totalSegundos/segundosPorMinuto;
            totalSegundos = totalSegundos%segundosPorMinuto;
            int segundos = totalSegundos;
            System.out.println(dias+" dia(s)");
            System.out.println(horas+" hora(s)");
            System.out.println(minutos+" miuto(s)");
            System.out.println(segundos+" segundo(s)");
        

    }
    
}
