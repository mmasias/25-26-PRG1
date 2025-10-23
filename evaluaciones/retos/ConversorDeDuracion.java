package evaluaciones.retos;

import java.util.Scanner;

public class ConversorDeDuracion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
      System.out.println("cuantos segundos desea convertir?");
      int segundos=scanner.nextInt();

      final int SEGUNDOS_POR_MINUTO=60;
        final int SEGUNDOS_POR_HORA=3600;
        final int SEGUNDOS_POR_DIA=86400;

        int dias=segundos/SEGUNDOS_POR_DIA;
        int resto=segundos%SEGUNDOS_POR_DIA;
        System.out.println(dias+" dias");
        int horas=resto/SEGUNDOS_POR_HORA;
        resto=resto%SEGUNDOS_POR_HORA;
        System.out.println(horas+" horas");
        int minutos=resto/SEGUNDOS_POR_MINUTO;
        resto=resto%SEGUNDOS_POR_MINUTO;
        System.out.println(minutos+" minutos");
        System.out.println(resto+" segundos");  
        


    }
    
}
