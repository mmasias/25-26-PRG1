import java.util.Scanner;
class Convertidor{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuantos años tienes?");
        double edad;
        edad = scanner.nextDouble();

    double edadMeses, edadDias, edadHoras, edadMinutos, edadSegundos;

    final int MESES_POR_AÑO = 12;
    final int DIAS_POR_AÑO = 365;
    final int HORAS_POR_DIA = 24;
    final int MINUTOS_POR_HORA = 60;
    final int SEGUNDOS_POR_MINUTO = 60;

    edadMeses = edad * MESES_POR_AÑO;
    edadDias = edad * DIAS_POR_AÑO;
    edadHoras = edadDias * HORAS_POR_DIA;
    edadMinutos = edadHoras * MINUTOS_POR_HORA;
    edadSegundos = edadMinutos * SEGUNDOS_POR_MINUTO;

    System.out.println("Tu edad en meses es: " + edadMeses);
    System.out.println("Tu edad en dias es: " + edadDias);
    System.out.println("Tu edad en horas es: " + edadHoras);
    System.out.println("Tu edad en minutos es: " + edadMinutos);
    System.out.println("Tu edad en segundos es: " + edadSegundos);
    scanner.close();
    




    }

}
    
