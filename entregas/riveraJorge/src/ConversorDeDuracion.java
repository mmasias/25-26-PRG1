import java.util.Scanner;

        class ConversorDeDuracion {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        final int SEGUNDOS_EN_UN_DIA = 86400;
        final int SEGUNDOS_EN_UNA_HORA = 3600;
        final int SEGUNDOS_EN_UN_MINUTO = 60;
        
        System.out.print("Cuantos segundos desea convertir?");
        
        int totalSegundos = scanner.nextInt();
        System.out.print(totalSegundos);
        int dias = totalSegundos / SEGUNDOS_EN_UN_DIA;
        totalSegundos = totalSegundos % SEGUNDOS_EN_UN_DIA;
         int horas = totalSegundos / SEGUNDOS_EN_UNA_HORA;
         totalSegundos = totalSegundos % SEGUNDOS_EN_UNA_HORA;
         int minutos = totalSegundos / SEGUNDOS_EN_UN_MINUTO;
         totalSegundos = totalSegundos % SEGUNDOS_EN_UN_MINUTO;
         
         System.out.println (" Son " + dias + " dias");
         System.out.println (" Son " + horas + " horas");
         System.out.println (" Son " + minutos + " minutos");
         System.out.println (" Son " + totalSegundos + " segundos");
                 
               
      
                
    }
}