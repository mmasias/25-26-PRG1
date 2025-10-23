
import java.util.Scanner;

public class Reto_002 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 

        int vidaGuerrero = 150;
        final int ARMA1 = 7;
        final double PROBABILIDAD_ARMA1 = 0.5;
        final int ARMA2 = 15;
        final double PROBABILIDAD_ARMA2 = 0.25;
        final int ARMA3 = 30;
        final double PROBABILIDAD_ARMA3 = 0.12;


        int vidaVampiro = 60;
        final int ATAQUE1 = 5;
        final double PROBABILIDAD_ATAQUE1 = 0.9;
        final int ATAQUE2 = 10;
        final double PROBABILIDAD_ATAQUE2 = 0.6;
        final int ATAQUE3 = 20;
        final double PROBABILIDAD_ATAQUE3 = 0.4;


        boolean algunMuerto = false;
        boolean guerreroVivo = true;
        boolean vampiroVivo = true;

        do {
            System.out.println("¿Qué arma quieres usar?(1,2,3)");
            int arma = scanner.nextInt();

            if(arma == 1){
                if(Math.random()<PROBABILIDAD_ARMA1){
                vidaVampiro = vidaVampiro - ARMA1;
                System.out.println("El vampiro recibe daño del arma1");
                }else{
                     System.out.println("El vampiro esquiva el arma1");
                }
               
            }else if(arma==2){
               if(Math.random()<PROBABILIDAD_ARMA2){
                vidaVampiro = vidaVampiro - ARMA2;
                System.out.println("El vampiro recibe daño del arma2");
               }else{
                System.out.println("El vampiro esquiva el arma2");
               }
            }else if(arma==3){
                if(Math.random()<PROBABILIDAD_ARMA3){
                    vidaVampiro = vidaVampiro - ARMA3;
                    System.out.println("El vampiro recibe daño del arma3");
                }else{
                    System.out.println("El vampiro esquiva el arma3");
                }
            }

            vampiroVivo = vidaVampiro> 0;

            if(vampiroVivo){
                int ataque = ((int)(Math.random()*100))%3+1;
                System.out.println("Arma elegida por el vampiro: "+ataque);

             if(ataque == 1){
                if(Math.random()<PROBABILIDAD_ATAQUE1){
                vidaGuerrero = vidaGuerrero - ATAQUE1;
                System.out.println("El guerrero recibe daño del ataque1");
                }else{
                     System.out.println("El guerrero esquiva el ataque1");
                }
               
            }else if(ataque==2){
               if(Math.random()<PROBABILIDAD_ATAQUE2){
                vidaGuerrero = vidaGuerrero - ATAQUE2;
                System.out.println("El guerrero recibe daño del ataque2");
               }else{
                System.out.println("El guerrero esquiva el ataque2");
               }
            }else if(ataque==3){
                if(Math.random()<PROBABILIDAD_ATAQUE3){
                    vidaGuerrero = vidaGuerrero - ATAQUE3;
                    System.out.println("El guerrero recibe daño del ataque3");
                }else{
                    System.out.println("El guerrero esquiva el ataque3");
                }
            }
            }
            System.out.println("Vida Guerrero [" + vidaGuerrero + "]/Vida Vampiro[" + vidaVampiro + "]");

            guerreroVivo = vidaGuerrero>0;

            algunMuerto = !guerreroVivo || !vampiroVivo;

        }while(!algunMuerto);

    String elGanador = vidaGuerrero > 0 ? "Guerrero" : "Vampiro";System.out.println("Ganó el "+elGanador);
}
}
