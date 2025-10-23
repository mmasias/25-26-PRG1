import java.util.Scanner;

public class Batalla {
    public static void main(String[] args) {
    
        final int DAÑO_HACHA = 2;
        int vidaGuerrero = 10;
        final double PORCENTAJE_EXITO_GUERRERO = 0.5;

        final int DAÑO_MORDIDA = 4;
        int vidaVampiro = 10;
        final double PORCENTAJE_EXITO_VAMPIRO = 0.5;

        boolean algunMuerto = false;

        do {
            
            if (!algunMuerto && Math.random() < PORCENTAJE_EXITO_GUERRERO) {
                vidaVampiro = vidaVampiro - DAÑO_HACHA;
                System.out.println("El vampiro recibe una hostia");
                if (vidaVampiro <= 0) {
                    algunMuerto = true;
                }
            } else if (!algunMuerto) {
                System.out.println("El guerrero ha fallado el ataque");
            }   

            
            if (!algunMuerto && Math.random() < PORCENTAJE_EXITO_VAMPIRO) {
                vidaGuerrero = vidaGuerrero - DAÑO_MORDIDA;
                System.out.println("El guerrero recibe una mordida");
                if (vidaGuerrero <= 0) {
                    algunMuerto = true;
                }
            } else if (!algunMuerto) {
                System.out.println("El vampiro ha fallado el ataque");
            }
        } while (!algunMuerto);

        
        if (vidaVampiro <= 0) {
            System.out.println("¡El guerrero ha ganado!");
        } else {
            System.out.println("¡El vampiro ha ganado!");
        }
    }
}
