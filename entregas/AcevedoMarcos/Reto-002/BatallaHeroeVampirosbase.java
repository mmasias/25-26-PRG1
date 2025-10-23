import java.util.Scanner;

public class BatallaHeroeVampirosbase {

    public static void main(String[] args) {

        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;
        final int DAÑO_ESPADA = 2;

        int vidaGuerrero = 10;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;
        final int DAÑO_MORDIDA = 4;

        boolean algunMuerto = false;

        do {
            if (Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro -= DAÑO_ESPADA;
                System.out.println("El vampiro ha recibido una hostia");
            } else {
                System.out.println("El vampiro esquiva la hostia");
            }

            if (vidaVampiro <= 0) {
                algunMuerto = true;
            } else {
                if (Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                    vidaGuerrero -= DAÑO_MORDIDA;
                    System.out.println("El guerrero ha recibido una mordida");
                } else {
                    System.out.println("El guerrero esquiva la mordida");
                }
            }

            if (vidaGuerrero <= 0) {
                algunMuerto = true;
            }

            System.out.println("Vida Guerrero [" + vidaGuerrero + "] / Vida Vampiro [" + vidaVampiro + "]");

        } while (!algunMuerto);

        System.out.println("La batalla ha terminado");

        if (vidaGuerrero > 0) {
            System.out.println("El guerrero ha ganado");
        } else {
            System.out.println("El vampiro ha ganado");
        }
    }
}
 
    
