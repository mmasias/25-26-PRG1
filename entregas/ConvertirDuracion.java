
import java.util.Scanner;

public class ConvertirDuracion{
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("¿Cuántos segundos desea convertir?");
    int segundos = sc.nextInt();

    int dias = segundos/86400;

    segundos = segundos%86400;

    int horas = segundos/(60*60);

    segundos = segundos%(60*60);

    int minutos = segundos/60;

    segundos = segundos%60;

    System.out.println(dias+(dias>1?" dias":" dia"));
    System.out.println(horas+(horas>1?" horas":" hora"));
    System.out.println(minutos+(minutos>1?" minutos":" minuto"));
    System.out.println(segundos+(segundos>1?" segundos":" segundo"));

    System.out.println(dias+" dia"+(dias>1?"s":""));
    System.out.println(horas+" hora"+(horas>1?"s":""));
    System.out.println(minutos+" minuto"+(minutos>1?"s":""));
    System.out.println(segundos+" segundo"+(segundos>1?"s":""));
}

}