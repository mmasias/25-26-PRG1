import java.util.Scanner;
class Convertidor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Dime tu edad");
        double edad;
        edad = scanner.nextDouble();

        double edadMeses, edadDias, edadHoras, edadMinutos, edadSegundos;
        final int MESES_EN_UN_AÑO = 12;
        final int DIAS_EN_UN_MES = 30;
        final int HORAS_EN_UN_DIA = 24;
        final int MINUTOS_EN_UNA_HORA = 60;
        final int SEGUNDOS_EN_UN_MINUTO = 60;

        edadMeses = edad * MESES_EN_UN_AÑO;
        edadDias = edadMeses * DIAS_EN_UN_MES;
        edadHoras = edadDias * HORAS_EN_UN_DIA;
        edadMinutos = edadDias * MINUTOS_EN_UNA_HORA;
        edadSegundos = edadMinutos * SEGUNDOS_EN_UN_MINUTO;
        
        System.out.println(edadMeses);
        System.out.println(edadDias);
        System.out.println(edadHoras);
        System.out.println(edadMinutos);
        System.out.println(edadSegundos);
    }
}