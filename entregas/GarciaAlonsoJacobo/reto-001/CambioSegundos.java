import java.util.Scanner;

public class CambioSegundos {

  public static void main(String[] args) {

    System.out.println("¿cuantos segundos desea convertir?");
    int segundos;
    Scanner scanner = new Scanner(System.in);
    segundos = scanner.nextInt();
    final int DIAS_SEGUNDOS = 86400;
    final int HORAS_SEGUNDOS = 3600;
    final int MINUTOS_SEGUNDOS = 60;

    int dias, horas, minutos, restoSegundos;

    dias = segundos / DIAS_SEGUNDOS;
    restoSegundos = segundos % DIAS_SEGUNDOS;

    horas = restoSegundos / HORAS_SEGUNDOS;
    restoSegundos = restoSegundos % HORAS_SEGUNDOS;

    minutos = restoSegundos / MINUTOS_SEGUNDOS;
    restoSegundos = restoSegundos % MINUTOS_SEGUNDOS;

    String nombreDia = dias > 1 ? "dias" : "dia";
    String nombreHoras = horas > 1 ? "horas" : "hora";
    String nombreMinutos = minutos > 1 ? "minutos" : "minuto";
    String nombreRestodesegundos = restoSegundos > 1 ? "restoSegundos" : "restoSegundo";

    System.out.println(dias == 0 ? "" : nombreDia + ": " + dias);
    System.out.println(horas == 0 ? "" : nombreHoras + ": " + horas);
    System.out.println(minutos == 0 ? "" : nombreMinutos + ": " + minutos);
    System.out.println(restoSegundos == 0 ? "" : nombreRestodesegundos + ": " + restoSegundos);

    scanner.close();

  }
}
