import java.util.Scanner;


public class ConvertirDuracion {

public static void main(String[] args) {
Scanner teclado = new Scanner(System.in);
final int DIAS_EN_SEGUNDOS = 86400;
final int HORAS_EN_SEGUNDOS = 3600;
final int MINUTOS_EN_SEGUNDOS = 60;
final int SEGUNDOS = 1;
final int MINUTOS_EN_HORAS =60;

System.out.println("¿Cuántos segundos desea convertir?");
int segundos = teclado.nextInt();
int dias = segundos / DIAS_EN_SEGUNDOS;
int horas = (segundos % DIAS_EN_SEGUNDOS) /HORAS_EN_SEGUNDOS;
int minutos = (segundos % HORAS_EN_SEGUNDOS) /MINUTOS_EN_SEGUNDOS;
int segundosConvertidos = (segundos % MINUTOS_EN_SEGUNDOS) /SEGUNDOS;
System.out.println ( minutos + "minutos");
System.out.println ( segundos + "segundos");
System.out.println ( horas + "horas");
System.out.println ( dias + "dias");
System.out.println (segundosConvertidos + "segundos");
teclado.close();

}
}

