import java.util.Scanner;

public class edificiohotel {
    public static void main(String[] args) {
    final double persianaabierta = 0.7;
    final double luzencendida = 0.6;

    final String ventana_cerrada= "[]";
    final String ventana_abierta_con_luz= "[*]";
    final String ventana_abierta_sin_luz= "[º]";

    boolean abierta, encendida; 
    for (int j=1; j<=7; j++) {
         abierta = Math.random() < persianaabierta;
    encendida = Math.random() < luzencendida;
    System.out.print("abierta ? ventana_cerrada : ventana_abierta_con_luz : ventana_abierta_sin_luz");
    }
}
}